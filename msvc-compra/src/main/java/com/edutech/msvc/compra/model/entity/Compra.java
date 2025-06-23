package com.edutech.msvc.compra.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "compra")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "id_curso", nullable = false)
    @NotNull(message = "El campo id_curso no puede estar vacío")
    private Long idCurso;

    @Column(name = "id_profesor", nullable = false)
    @NotNull(message = "El campo id_profesor no puede estar vacío")
    private Long idProfesor;

    @Column(name = "id_alumno", nullable = false)
    @NotNull(message = "El campo id_alumno no puede estar vacío")
    private Long idAlumno;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_total", nullable = false)
    private Integer precioTotal;

    @Column(name = "cupon", nullable = true)
    private String cupon;

    @Column(name = "fecha_compra", nullable = false)
    @NotNull(message = "El campo fecha_compra no puede estar vacío")
    private LocalDateTime fechaCompra;
}
