package com.edutech.msvc.cursos.dtos;

import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class CursoUpdateDTO {
    private String nombre;
    private String comentario;
    private Long duracion;
    private Long precio;
    private Boolean estado;
}
