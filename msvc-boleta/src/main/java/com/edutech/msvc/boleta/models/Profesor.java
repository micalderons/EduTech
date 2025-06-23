package com.edutech.msvc.boleta.models;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {

    private Long idProfesor;
    private String runProfesor;
    private LocalDate fechaNacimiento;
    private String nombreCompleto;
}
