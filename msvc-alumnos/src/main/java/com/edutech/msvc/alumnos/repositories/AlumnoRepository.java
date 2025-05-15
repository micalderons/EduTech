package com.edutech.msvc.alumnos.repositories;

import com.edutech.msvc.alumnos.models.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
