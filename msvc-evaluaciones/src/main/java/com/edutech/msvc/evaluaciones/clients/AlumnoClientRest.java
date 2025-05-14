package com.edutech.msvc.evaluaciones.clients;

import com.edutech.msvc.evaluaciones.models.Alumno;
import com.edutech.msvc.evaluaciones.models.Prueba;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-alumno", url = "localhost:8082/api/v1/alumno")
public interface AlumnoClientRest {
    @GetMapping
    List<Alumno> findAll();

    @GetMapping("/{id}")
    Alumno findById(@PathVariable Long id);
}
