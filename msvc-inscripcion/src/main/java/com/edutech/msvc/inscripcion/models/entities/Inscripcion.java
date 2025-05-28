package com.edutech.msvc.inscripcion.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Long idInscripcion;

    @Column(name = "hora_inscripcion", nullable = false)
    @NotNull(message = "Campo horaInscripcion no puede estar vacio")
    private LocalDate fechaInscripcion;

    @Column(name = "id_curso", nullable = false)
    @NotNull(message = "Campo idCurso no puede estar vacia")
    private Long idCurso;

    @Column(name = "id_alumno", nullable = false)
    @NotNull(message = "Campo idAlumno no puede estar vacia")
    private Long idAlumno;
}
