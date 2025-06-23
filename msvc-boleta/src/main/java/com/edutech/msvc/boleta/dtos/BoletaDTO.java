package com.edutech.msvc.boleta.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoletaDTO {

    private LocalDateTime fechaBoleta;
    private Integer total;
    private ProfesorDTO profesor;
    private AlumnoDTO alumno;
    private CursoDTO curso;

}
