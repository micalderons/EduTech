package com.edutech.msvc.evaluaciones.services;

import com.edutech.msvc.evaluaciones.dtos.EvaluacionDTO;
import com.edutech.msvc.evaluaciones.models.entities.Evaluacion;

import java.util.List;

public interface EvaluacionesService {

    List<EvaluacionDTO> findAll();
    Evaluacion findById(Long id );
    Evaluacion save (Evaluacion evaluacion);
    List<Evaluacion> findByIdAlumno(Long alumnoId);
    List<Evaluacion> findByIdPrueba(Long pruebaId);

}
//en save despues cambiar Nota por NotaCreationDTO