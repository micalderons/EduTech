package com.edutech.msvc.profesores.repositories;

import com.edutech.msvc.profesores.models.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Long> {
}
