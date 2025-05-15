package com.edutech.msvc.cursos.repositories;

import com.edutech.msvc.cursos.models.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
