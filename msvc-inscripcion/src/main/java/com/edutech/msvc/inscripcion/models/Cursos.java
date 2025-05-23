package com.edutech.msvc.inscripcion.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Cursos {
    private Long idCurso;
    private String nombre;
    private String comentario;
    private Long duracion;
    private LocalDate fechaCreacion;
    private Long precio;
    private Boolean estado;
}
