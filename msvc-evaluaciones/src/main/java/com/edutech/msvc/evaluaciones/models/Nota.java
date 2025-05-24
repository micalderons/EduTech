package com.edutech.msvc.evaluaciones.models;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long idNota;
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
    private String idCurso;

}
