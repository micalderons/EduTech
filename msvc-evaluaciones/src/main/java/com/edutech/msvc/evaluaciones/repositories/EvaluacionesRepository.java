package com.edutech.msvc.evaluaciones.repositories;

import com.edutech.msvc.evaluaciones.models.entities.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionesRepository extends JpaRepository<Evaluacion, Long> {
    List<Evaluacion> findByIdAlumno(Long idAlumno);

    List<Evaluacion> findByIdPrueba(Long idNota);
}
