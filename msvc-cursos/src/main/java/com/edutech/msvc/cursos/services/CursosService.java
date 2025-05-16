package com.edutech.msvc.cursos.services;

import com.edutech.msvc.cursos.models.entities.Cursos;

import java.util.List;

public interface CursosService {
    List<Cursos> findAll();
    Cursos findById(Long id);
    Cursos save(Cursos curso);
}
