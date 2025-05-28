package com.edutech.msvc.inscripcion.services;

import com.edutech.msvc.inscripcion.clients.AlumnoClientRest;
import com.edutech.msvc.inscripcion.clients.CursosClientRest;
import com.edutech.msvc.inscripcion.dtos.AlumnoDTO;
import com.edutech.msvc.inscripcion.dtos.CursoDTO;
import com.edutech.msvc.inscripcion.dtos.InscripcionDTO;
import com.edutech.msvc.inscripcion.exceptions.InscripcionException;
import com.edutech.msvc.inscripcion.models.Alumnos;
import com.edutech.msvc.inscripcion.models.Cursos;
import com.edutech.msvc.inscripcion.models.entities.Inscripcion;
import com.edutech.msvc.inscripcion.repositories.InscripcionRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionServiceImpl implements InscripcionService{

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private AlumnoClientRest alumnoClientRest;

    @Autowired
    private CursosClientRest cursosClientRest;

    @Override
    public List<InscripcionDTO> findAll() {
        return this.inscripcionRepository.findAll().stream().map(inscripcion -> {
            Alumnos alumno = null;
            try{
                alumno = this.alumnoClientRest.findById(inscripcion.getIdAlumno());
            }catch (FeignException ex){
                throw new InscripcionException("El alumno buscado no existe");
            }

            Cursos curso = null;
            try {
                curso = this.cursosClientRest.findById(inscripcion.getIdCurso());
            }catch (FeignException ex){
                throw new InscripcionException("El curso no existe en la base de datos");
            }

            AlumnoDTO alumnoDTO = new AlumnoDTO();
            alumnoDTO.setRun(alumno.getRun());
            alumnoDTO.setNombres(alumno.getNombres());
            alumnoDTO.setApellidos(alumno.getApellidos());
            alumnoDTO.setCorreo(alumno.getCorreo());
            alumnoDTO.setFechaNacimiento(alumno.getFechaNacimiento());

            CursoDTO cursoDTO = new CursoDTO();
            cursoDTO.setNombre(curso.getNombre());
            cursoDTO.setComentario(curso.getComentario());
            cursoDTO.setDuracion(curso.getDuracion());
            cursoDTO.setFechaCreacion(curso.getFechaCreacion());
            cursoDTO.setPrecio(curso.getPrecio());

            InscripcionDTO inscripcionDTO = new InscripcionDTO();
            inscripcionDTO.setAlumno(alumnoDTO);
            inscripcionDTO.setCurso(cursoDTO);
            inscripcionDTO.setFechaInscripcion(inscripcion.getFechaInscripcion());

            return inscripcionDTO;
        }).toList();
    }

    @Override
    public Inscripcion findById(Long id) {
        return this.inscripcionRepository.findById(id).orElseThrow(
                () -> new InscripcionException("La inscripcion con id: " + id + " no se encuentra en la base de datos")
        );
    }

    @Override
    public Inscripcion save(Inscripcion inscripcion) {
        try{
            Alumnos alumno = this.alumnoClientRest.findById(inscripcion.getIdAlumno());
        }catch (FeignException ex) {
            throw new InscripcionException("Existen problemas con la asosiacion Alumno");
        }
        try{
            Cursos curso = this.cursosClientRest.findById(inscripcion.getIdCurso());
        }catch (FeignException ex) {
            throw new InscripcionException("Existen problemas con la asosiacion Curso");
        }
        return this.inscripcionRepository.save(inscripcion);
    }

    @Override
    public List<Inscripcion> findByAlumnoId(Long alumnoId) {
        return this.inscripcionRepository.findByIdAlumno(alumnoId);
    }

    @Override
    public List<Inscripcion> findByCursoId(Long cursoId) {
        return this.inscripcionRepository.findByIdCurso(cursoId);
    }
}
