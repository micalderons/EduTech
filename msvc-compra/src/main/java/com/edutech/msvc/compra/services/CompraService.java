package com.edutech.msvc.compra.services;

import com.edutech.msvc.compra.dtos.CompraDTO;
import com.edutech.msvc.compra.model.entity.Compra;

import java.util.List;

public interface CompraService {

    List<CompraDTO> findAll();

    Compra findById(Long id);

    Compra save(Compra compra);

    List<Compra> findByAlumnoId(Long alumnoId);

    List<Compra> findByProfesorId(Long profesorId);
}
