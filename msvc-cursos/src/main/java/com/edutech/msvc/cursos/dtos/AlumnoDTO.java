package com.edutech.msvc.cursos.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class AlumnoDTO {

    private String run;
    private String nombreCompleto;
}
