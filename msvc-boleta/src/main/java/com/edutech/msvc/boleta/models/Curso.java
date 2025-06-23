package com.edutech.msvc.boleta.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    private Long idCurso;
    private String nombreCurso;
    private String descripcionCurso;
}
