package com.edutech.msvc.profesores.client;

import com.edutech.msvc.profesores.models.Cursos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-cursos", url = "localhost:8002/api/v1/curso")
public interface CursoClientRest {
    @GetMapping("/{id}")
    Cursos findById(@PathVariable Long id);
}
