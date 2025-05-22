package com.edutech.msvc_profesores.services;

import com.edutech.msvc_profesores.dtos.EstadoProfesorDTO;
import com.edutech.msvc_profesores.dtos.UpdateProfesorDTO;
import com.edutech.msvc_profesores.models.entities.Profesor;

import java.util.List;

public interface ProfesorService {
    List<Profesor> findAll();
    Profesor findById(Long id);
    Profesor save(Profesor profesor);
    Profesor updateById(Long id, UpdateProfesorDTO updateProfesorDTO);
    void delete(Long id);
    Profesor cambiarEstadoCuenta(Long id, EstadoProfesorDTO estadoProfesorDTO);
}
