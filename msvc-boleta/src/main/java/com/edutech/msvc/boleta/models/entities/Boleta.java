package com.edutech.msvc.boleta.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "boletas")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Boleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleta")
    private Long idBoleta;

    @Column(name = "fecha_boleta", nullable = false)
    @NotNull(message = "El campo fecha boleta no puede estar vacío, con formato 'YYYY-MM-DD HH:MM:SS'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaBoleta;

    @Column(nullable = false)
    @NotNull(message = "El campo total no puede estar vacío")
    private Integer total;

    @Column(name = "id_curso")
    @NotNull(message = "El campo id curso no puede estar vacío")
    private Long idCurso;

    @Column(name = "id_profesor")
    @NotNull(message = "El campo id profesor no puede estar vacío")
    private Long idProfesor;

    @Column(name = "id_alumno")
    private Long idAlumno;
}
