package com.edutech.msvc.compra.dtos;

import lombok.*;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RestController
public class CursoDTO {

    private Long idCurso;
    private String nombreCurso;
    private Integer precio;
    private String descripcion;
}
