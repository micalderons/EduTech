package com.edutech.msvc.evaluaciones.dtos;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class AlumnoDTO {
    private String run;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String correo;
    private String contraseña;
    private Boolean cuentaActiva;
}
