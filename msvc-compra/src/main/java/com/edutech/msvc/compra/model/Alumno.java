package com.edutech.msvc.compra.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

    private Long idAlumno;
    private String runAlumno;  // RUT del alumno
    private LocalDate fechaNacimiento;
    private String nombreCompleto;
    private boolean estadoCuenta;  // activo o inactivo
    private Long idCurso; // Curso que compra o al que está inscrito
}
