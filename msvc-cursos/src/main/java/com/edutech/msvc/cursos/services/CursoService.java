package com.edutech.msvc.cursos.services;

import com.edutech.msvc.cursos.dtos.InscripcionCursoDTO;
import com.edutech.msvc.cursos.models.entities.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> findAll();
    Curso findById(Long id);
    Curso save(Curso curso);
    List<InscripcionCursoDTO> findInscripcionesById(Long cursoId);
}
