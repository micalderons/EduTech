package com.edutech.msvc.alumnos.servicies;

import com.edutech.msvc.alumnos.dtos.EstadoDTO;
import com.edutech.msvc.alumnos.dtos.InscripcionAlumnoDTO;
import com.edutech.msvc.alumnos.models.entities.Alumno;
import com.edutech.msvc.alumnos.dtos.UpdateAlumnoDTO;

import java.util.List;

public interface AlumnoService {
    List<Alumno> findAll();
    Alumno findById(Long id);
    Alumno save(Alumno alumno);
    Alumno updateById(Long id, UpdateAlumnoDTO updateAlumnoDTO);
    void delete(Long id);
    Alumno cambiarEstadoCuenta(Long id, EstadoDTO estadoDTO);
    List<InscripcionAlumnoDTO> findInscripcionesById(Long alumnoId);
}
