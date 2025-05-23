package com.edutech.msvc.prueba.services;

import com.edutech.msvc.prueba.dtos.PruebaDTO;
import com.edutech.msvc.prueba.models.entities.Prueba;

import java.util.List;

public interface PruebaService {

    List<PruebaDTO> findAll();
    Prueba findById(Long id);
    Prueba save(Prueba prueba);
    List<Prueba> findByIdCurso(Long cursoId);
    List<Prueba> findByIdProfesor(Long profesorId);
}
