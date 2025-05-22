package com.edutech.msvc.prueba.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.lang.reflect.GenericSignatureFormatError;
@Entity
@Table(name = "prueba")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prueba")
    private Long idPrueba;

    @Column(nullable = false)
    @NotNull(message = "El campo idNota no puede estar vacio")
    private Long idNota;

    @Column(nullable = false)
    @NotNull(message = "El campo idProfe no puede estar vacio")
    private Long idProfesor;

    @Column(nullable = false)
    @NotNull(message = "el campo idCurso no debe de estar vacio")
    private Long idCurso;

}
