package com.edutech.msvc.prueba.dtos;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class ProfesorDTO {

    private String run;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String correo;
    private String contrasenia;
    private Boolean cuentaActiva;
}
