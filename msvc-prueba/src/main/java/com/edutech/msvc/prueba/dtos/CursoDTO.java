package com.edutech.msvc.prueba.dtos;

import lombok.*;

import java.time.LocalDate;
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class CursoDTO {

    private String comentario;
    private Long duracion;
    private LocalDate fechaCreacion;
    private Long precio;
    private Boolean estado;
}
