package com.edutech.msvc.profesores.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pruebas {
    private Long idPrueba;
    private Long idNota;
    private Long idProfesor;
    private Long idCurso;
}
