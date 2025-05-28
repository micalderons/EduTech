package com.edutech.msvc.cursos.services;

import com.edutech.msvc.cursos.clients.AlumnoClientRest;
import com.edutech.msvc.cursos.clients.InscripcionClientRest;
import com.edutech.msvc.cursos.dtos.AlumnoDTO;
import com.edutech.msvc.cursos.dtos.InscripcionCursoDTO;
import com.edutech.msvc.cursos.exceptions.CursoException;
import com.edutech.msvc.cursos.models.Alumno;
import com.edutech.msvc.cursos.models.Inscripcion;
import com.edutech.msvc.cursos.models.entities.Curso;
import com.edutech.msvc.cursos.repositories.CursoRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscripcionClientRest inscripcionClientRest;

    @Autowired
    private AlumnoClientRest alumnoClientRest;

    @Override
    public List<Curso> findAll(){ return this.cursoRepository.findAll();}

    @Override
    public Curso findById(Long id){
        return this.cursoRepository.findById(id).orElseThrow(
                () -> new CursoException("El curso con id: " + id + " no se encuentra en la base de datos")
        );
    }

    @Override
    public Curso save(Curso curso){
        return this.cursoRepository.save(curso);
    }

    @Override
    public List<InscripcionCursoDTO> findInscripcionesById(Long cursoId) {
        Curso curso = this.findById(cursoId);

        List<Inscripcion> inscripciones = this.inscripcionClientRest.findByIdCurso(cursoId);
        if (!inscripciones.isEmpty()){
           return inscripciones.stream().map(inscripcion -> {
               InscripcionCursoDTO inscripcionCursoDTO = new InscripcionCursoDTO();
               Alumno alumno = null;
               try{
                   alumno = this.alumnoClientRest.findById(inscripcion.getIdAlumno());
               }catch (FeignException ex){
                   throw new CursoException("Al momento de generar la vista inscripciones de curso no "+
                           "se pudo encontrar al alumno con id " + inscripcion.getIdAlumno());
               }

               AlumnoDTO alumnoDTO = new AlumnoDTO();
               alumnoDTO.setRun(alumno.getRun());
               alumnoDTO.setNombreCompleto(alumno.getNombres()+alumno.getApellidos());

               inscripcionCursoDTO.setFechaInscripcion(LocalDate.now());
               inscripcionCursoDTO.setAlumno(alumnoDTO);

               return inscripcionCursoDTO;

           }).toList();
        }
        return List.of();
    }
}
