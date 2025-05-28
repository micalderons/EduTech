package com.edutech.msvc.evaluaciones.services;

import com.edutech.msvc.evaluaciones.clients.AlumnoClientRest;
import com.edutech.msvc.evaluaciones.clients.PruebaClientRest;
import com.edutech.msvc.evaluaciones.dtos.AlumnoDTO;
import com.edutech.msvc.evaluaciones.dtos.EvaluacionDTO;
import com.edutech.msvc.evaluaciones.dtos.PruebaDTO;
import com.edutech.msvc.evaluaciones.exceptions.EvaluacionException;
import com.edutech.msvc.evaluaciones.models.Alumno;
import com.edutech.msvc.evaluaciones.models.Prueba;
import com.edutech.msvc.evaluaciones.models.entities.Evaluacion;
import com.edutech.msvc.evaluaciones.repositories.EvaluacionesRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionesServiceImpl implements EvaluacionesService{

    @Autowired
    private EvaluacionesRepository evaluacionesRepository;

    @Autowired
    private AlumnoClientRest alumnoClientRest;

    @Autowired
    private PruebaClientRest pruebaClientRest;

    @Override
    public List<EvaluacionDTO> findAll(){
        return this.evaluacionesRepository.findAll().stream().map(evaluacion -> {
            Alumno alumno = null;
            try{
                alumno = this.alumnoClientRest.findById(evaluacion.getIdAlumno());
            }catch (FeignException e){
                throw new EvaluacionException("El alumno no existe");
            }

            Prueba prueba = null;
            try {
                prueba = this.pruebaClientRest.findById(evaluacion.getIdPrueba());
            }catch (FeignException e){
                throw new EvaluacionException("La prueba no existe");
            }

            AlumnoDTO alumnoDTO = new AlumnoDTO();
            alumnoDTO.setRun(alumno.getRun());
            alumnoDTO.setNombres(alumno.getNombres());
            alumnoDTO.setApellidos(alumno.getApellidos());
            alumnoDTO.setFechaNacimiento(alumno.getFechaNacimiento());
            alumnoDTO.setCorreo(alumno.getCorreo());
            alumnoDTO.setContraseña(alumnoDTO.getContraseña());
            alumnoDTO.setCuentaActiva(alumnoDTO.getCuentaActiva());

            PruebaDTO pruebaDTO = new PruebaDTO();
            pruebaDTO.setIdAlumno(evaluacion.getIdAlumno());
            pruebaDTO.setIdCurso(prueba.getIdCurso());
            pruebaDTO.setIdCurso(prueba.getIdCurso());

            EvaluacionDTO evaluacionDTO = new EvaluacionDTO();
            evaluacionDTO.setIdAlumno(alumnoDTO);
            evaluacionDTO.setIdPrueba(pruebaDTO);

            return evaluacionDTO;

        }).toList();
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @Override
    public Evaluacion findById(Long id){
        return this.evaluacionesRepository.findById(id).orElseThrow(
                ()-> new EvaluacionException("Nota con id "+id+"no encontrada")
        );
    }

    @Override
    public Evaluacion save (Evaluacion evaluacion){
        try {
            Prueba prueba = this.pruebaClientRest.findById(evaluacion.getIdPrueba());
        }catch (FeignException ex){
            throw new EvaluacionException("No se pudo guardar la evaluacion por culpa de la Prueba");
        }
        try {
            Alumno alumno = this.alumnoClientRest.findById(evaluacion.getIdAlumno());
        }catch (FeignException ex){
            throw new EvaluacionException("No se pudo guardar el evaluacion por culpa del Alumno");
        }
        return this.evaluacionesRepository.save(evaluacion);
    }


    @Override
    public List<Evaluacion> findByIdAlumno(Long idAlumno){
        return this.evaluacionesRepository.findByIdAlumno(idAlumno);
    }

    @Override
    public List<Evaluacion> findByIdPrueba(Long idPrueba){
        return this.evaluacionesRepository.findByIdPrueba(idPrueba);
    }


}
