package com.edutech.msvc.prueba.clients;

import com.edutech.msvc.prueba.models.Cursos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-curso", url = "localhost:8081/api/v1/curso")
public interface CursosClientRest {

    @GetMapping
    List<Cursos> findAll();

    @GetMapping("/{id}")
    Cursos findById(@PathVariable Long id);
}
