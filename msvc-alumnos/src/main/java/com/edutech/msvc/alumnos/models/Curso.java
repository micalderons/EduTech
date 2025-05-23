package com.edutech.msvc.alumnos.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    private Long idCurso;
    private String nombre;
    private String comentario;
    private Long duracion;
    private LocalDate fechaCreacion;
    private Long precio;
    private Boolean estado;
}
