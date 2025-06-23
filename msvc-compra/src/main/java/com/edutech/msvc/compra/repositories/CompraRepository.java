package com.edutech.msvc.compra.repositories;

import com.edutech.msvc.compra.model.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findByIdAlumno(Long idAlumno);

    List<Compra> findByIdProfesor(Long idProfesor);
}
