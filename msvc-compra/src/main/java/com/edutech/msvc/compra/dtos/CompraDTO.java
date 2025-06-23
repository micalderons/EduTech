package com.edutech.msvc.compra.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompraDTO {
    private ProfesorDTO profesor;
    private AlumnoDTO alumno;
    private CursoDTO curso;
}
