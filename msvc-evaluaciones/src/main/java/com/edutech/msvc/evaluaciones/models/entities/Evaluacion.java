package com.edutech.msvc.evaluaciones.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "evaluacion")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long idEvaluacion;
    @NotNull(message = "La nota no puede ser vacio")
    private Float nota;
    @Column(name = "id_alumno")
    @NotNull(message = "La nota no puede ser vacio")
    private Long idAlumno;
    @Column(name = "id_profesor")
    @NotNull(message = "El profesor no puede ser vacio")
    private Long idProfesor;
    @Column(name = "id_curso")
    @NotNull(message = "El curso no puede ser vacio")
    private Long idPrueba;

}
