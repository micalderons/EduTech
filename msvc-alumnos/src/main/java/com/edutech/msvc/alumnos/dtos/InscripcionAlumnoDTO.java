package com.edutech.msvc.alumnos.dtos;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class InscripcionAlumnoDTO {

    private LocalDate fechaInscripcion;
    private CursoDTO curso;
}
