package com.edutech.msvc.compra.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    private Long idCurso;
    private String nombreCurso;
    private Integer precioCurso;
    private String descripcionCurso;
}
