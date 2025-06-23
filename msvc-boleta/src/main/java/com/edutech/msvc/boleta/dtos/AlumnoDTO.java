package com.edutech.msvc.boleta.dtos;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {

    private String runAlumno;
    private LocalDate fechaNacimiento;
    private String nombreCompleto;
}
