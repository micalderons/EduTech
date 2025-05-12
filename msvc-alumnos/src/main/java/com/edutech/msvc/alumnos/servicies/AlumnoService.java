package com.edutech.msvc.alumnos.servicies;

import com.edutech.msvc.alumnos.models.entities.Alumno;

import java.util.List;

public interface AlumnoService {
    List<Alumno> findAll();
    Alumno findById(Long id);
    Alumno save(Alumno alumno);
}
