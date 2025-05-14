package com.edutech.msvc.evaluaciones.repositories;

import com.edutech.msvc.evaluaciones.models.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionesRepository extends JpaRepository<Nota, Long> {
}
