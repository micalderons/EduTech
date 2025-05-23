package com.edutech.msvc.prueba.models;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cursos {
    private Long idCurso;
    private String comentario;
    private Long duracion;
    private LocalDate fechaCreacion;
    private Long precio;
    private Boolean estado;

}
