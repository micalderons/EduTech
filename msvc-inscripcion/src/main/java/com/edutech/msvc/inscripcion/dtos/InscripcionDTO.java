package com.edutech.msvc.inscripcion.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class InscripcionDTO {

    private LocalDateTime horaInscripcion;
    private CursoDTO curso;
    private AlumnoDTO alumno;
}
