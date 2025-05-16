package com.edutech.msvc.inscripcion.client;

import com.edutech.msvc.inscripcion.models.Alumnos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-alumnos", url = "localhost:8082/api/v1/alumno")
public interface AlumnoClientRest {

    @GetMapping("/{id}")
    public Alumnos findById(@PathVariable Long id);
}
