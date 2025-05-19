package com.edutech.msvc.profesores.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfesorDTO {

    @NotBlank(message = "El campo no puede ser vacio")
    private String nombres;


    @NotBlank(message = "El campo no puede ser vacio")
    private String apellidos;


    @NotNull(message = "El campo no puede ser vacio")
    private LocalDate fechaNacimiento;

    private String correo;


    @NotNull(message = "El campo no puede ser vacio")
    private String contraseña;
}
