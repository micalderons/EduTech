package com.edutech.msvc.alumnos.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion {
    private Long idInscripcion;
    private LocalDateTime horaInscripcion;
    private Long idCurso;
    private Long idAlumno;
}
