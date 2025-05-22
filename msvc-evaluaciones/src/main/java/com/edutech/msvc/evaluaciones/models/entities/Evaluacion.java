package com.edutech.msvc.evaluaciones.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "La nota no puede ser vacio")
    private Float nota;
    @Column(name = "id_alumno")
    @NotEmpty(message = "La nota no puede ser vacio")
    private String idAlumno;
    @Column(name = "id_profesor")
    @NotEmpty(message = "El profesor no puede ser vacio")
    private String idProfesor;
    @Column(name = "id_curso")
    @NotEmpty(message = "El curso no puede ser vacio")
    private String idPrueba;

}
