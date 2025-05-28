package com.edutech.msvc.inscripcion.clients;

import com.edutech.msvc.inscripcion.models.Cursos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-cursos", url = "localhost:8002/api/v1/cursos")
public interface CursosClientRest {

    @GetMapping("/{id}")
    Cursos findById(@PathVariable Long id);

}
