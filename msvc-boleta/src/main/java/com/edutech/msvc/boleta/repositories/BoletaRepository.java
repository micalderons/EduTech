package com.edutech.msvc.boleta.repositories;

import com.edutech.msvc.boleta.models.entities.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Long> {

    List<Boleta> findByIdAlumno(Long idAlumno);
    List<Boleta> findByIdProfesor(Long idProfesor);
    List<Boleta> findByIdCurso(Long idCurso);

}
