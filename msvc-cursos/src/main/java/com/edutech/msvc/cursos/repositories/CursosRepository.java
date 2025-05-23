package com.edutech.msvc.cursos.repositories;

import com.edutech.msvc.cursos.models.entities.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends JpaRepository<Cursos,Long> {
}
