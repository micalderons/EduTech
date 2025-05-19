package com.edutech.msvc.profesores.services;

import com.edutech.msvc.profesores.dtos.EstadoProfesorDTO;
import com.edutech.msvc.profesores.dtos.UpdateProfesorDTO;
import com.edutech.msvc.profesores.models.entities.Profesor;

import java.util.List;

public interface ProfesorService {
    List<Profesor> findAll();
    Profesor findById(Long id);
    Profesor save(Profesor profesor);
    Profesor updateById(Long id, UpdateProfesorDTO updateProfesorDTO);
    void delete(Long id);
    Profesor cambiarEstadoCuenta(Long id, EstadoProfesorDTO estadoProfesorDTO);
}
