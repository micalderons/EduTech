package com.edutech.msvc.alumnos.repositories;

import com.edutech.msvc.alumnos.models.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
