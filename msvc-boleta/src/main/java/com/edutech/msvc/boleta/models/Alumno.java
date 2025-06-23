package com.edutech.msvc.boleta.models;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Alumno {

    private Long idAlumno;
    private String runAlumno;
    private LocalDate fechaNacimiento;
    private String nombreCompleto;
}
