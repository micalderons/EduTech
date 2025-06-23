package com.edutech.msvc.boleta.clients;

import com.edutech.msvc.boleta.models.Curso;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-cursos", url = "http://localhost:8088/api/v1/cursos")
public interface CursoClientRest {

    @GetMapping("/{id}")
    Curso findById(@PathVariable Long id);
}
