package com.edutech.msvc.boleta.services;

import com.edutech.msvc.boleta.dtos.BoletaDTO;
import com.edutech.msvc.boleta.models.entities.Boleta;

import java.util.List;

public interface BoletaService {

    List<BoletaDTO> findAll();
    Boleta findById(Long id);
    Boleta save(Boleta boleta);
    List<Boleta> findByAlumnoId(Long alumnoId);
    List<Boleta> findByProfesorId(Long profesorId);
    List<Boleta> findByCursoId(Long cursoId);

}
