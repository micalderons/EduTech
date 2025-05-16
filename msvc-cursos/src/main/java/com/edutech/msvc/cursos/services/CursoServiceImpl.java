package com.edutech.msvc.cursos.services;

import com.edutech.msvc.cursos.clients.AlumnoClientRest;
import com.edutech.msvc.cursos.clients.InscripcionClientRest;
import com.edutech.msvc.cursos.dtos.InscripcionCursoDTO;
import com.edutech.msvc.cursos.exceptions.CursoException;
import com.edutech.msvc.cursos.models.entities.Curso;
import com.edutech.msvc.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                () -> new CursoException("El paciente con id: " + id + " no se encuentra en la base de datos")
        );
    }

    @Override
    public Curso save(Curso curso){
        return this.cursoRepository.save(curso);
    }

    @Override
    public List<InscripcionCursoDTO> findAtencionesById(Long cursoId) {
        return List.of();
    }
}
