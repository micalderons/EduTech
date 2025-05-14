package com.edutech.msvc.prueba.clients;

import com.edutech.msvc.prueba.models.Curso;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-curso", url = "localhost:8082/api/v1/curso")
public interface CursoClientRest {

    @GetMapping
    List<Curso> findAll();

    @GetMapping("/{id}")
    Curso findById(@PathVariable Long id);
}
