package com.edutech.msvc.alumnos.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Evaluacion {
    private Long idNota;
    private Float nota;
    private String idAlumno;
    private String idProfesor;
}
