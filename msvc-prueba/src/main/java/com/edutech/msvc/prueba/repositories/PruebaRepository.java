package com.edutech.msvc.prueba.repositories;

import com.edutech.msvc.prueba.models.entities.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long> {
    List<Prueba> findByIdProfesor(Long idProfesor);

    List<Prueba> findByIdCurso(Long idCurso);
}
