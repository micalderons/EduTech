package com.edutech.msvc.profesores.models;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cursos {
    private Long idCurso;
    private String nombre;
    private String comentario;
    private Long duracion;
    private LocalDate fechaCreacion;
    private Long precio;
    private Boolean estado;
}
