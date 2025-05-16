package com.edutech.msvc.cursos.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "curso")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @Column(nullable = false)
    @NotBlank(message = "El campo nombre no puede estar vacio")
    private String nombre;

    private String comentario;

    @Column(nullable = false)
    @NotNull(message = "El campo duracion no puede estar vacio")
    private Long duracion;

    @Column(name = "fecha_creacion", nullable = false)
    @NotNull(message = "El campo fecha creacion no puede estar vacio")
    private LocalDate fechaCreacion;

    @Column(nullable = false)
    @NotNull(message = "El campo precio no puede estara vacio")
    private Long precio;

    @Column(nullable = false)
    @NotNull(message = "El campo estado no puede quedar vacio")
    private Boolean estado;


}
