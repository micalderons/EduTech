package com.edutech.msvc.cursos.clients;

import com.edutech.msvc.cursos.models.Inscripcion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-inscripcion", url = "localhost:8004/api/v1/inscripciones")
public interface InscripcionClientRest {

    @GetMapping("curso/{id}")
    List<Inscripcion> findByIdCurso(@PathVariable Long id);
}
