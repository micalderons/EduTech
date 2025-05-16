package com.edutech.msvc.inscripcion.repositories;

import com.edutech.msvc.inscripcion.models.entities.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    List<Inscripcion> findByIdCurso(Long idCurso);

    List<Inscripcion> findByIdAlumno(Long idAlumno);
}
