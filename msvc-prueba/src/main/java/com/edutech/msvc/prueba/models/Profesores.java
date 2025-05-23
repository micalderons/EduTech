package com.edutech.msvc.prueba.models;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Profesores {
    private Long idProfesor;
    private String run;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String correo;
    private String contrasenia;
    private Boolean cuentaActiva;
}
