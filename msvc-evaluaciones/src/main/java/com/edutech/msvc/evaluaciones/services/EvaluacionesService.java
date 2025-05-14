package com.edutech.msvc.evaluaciones.services;

import com.edutech.msvc.evaluaciones.models.Nota;

import java.util.List;

public interface EvaluacionesService {

    List<Nota> findAll();
    Nota findById(Long id);
    Nota save (Nota nota);
}
//en save despues cambiar Nota por NotaCreationDTO