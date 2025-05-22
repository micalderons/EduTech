package com.edutech.msvc.evaluaciones.dtos;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EvaluacionDTO {

    private Float nota;

    private AlumnoDTO idAlumno;

    private PruebaDTO idPrueba;
}
