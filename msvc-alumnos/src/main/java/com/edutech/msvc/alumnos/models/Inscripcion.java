package com.edutech.msvc.alumnos.models;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion {
    private Long idInscripcion;
    private LocalDate fechaInscripcion;
    private Long idCurso;
    private Long idAlumno;
}
