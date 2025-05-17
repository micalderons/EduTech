package com.edutech.msvc.inscripcion.services;

import com.edutech.msvc.inscripcion.dtos.InscripcionDTO;
import com.edutech.msvc.inscripcion.models.entities.Inscripcion;

import java.util.List;

public interface InscripcionService {

    List<InscripcionDTO> findAll();
    Inscripcion findById(Long id);
    Inscripcion save(Inscripcion inscripcion);
    List<Inscripcion> findByIdAlumno(Long alumnoId);
    List<Inscripcion> findByIdCurso(Long cursoId);

}
