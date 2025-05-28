package com.edutech.msvc.inscripcion.clients;

import com.edutech.msvc.inscripcion.models.Alumnos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-alumnos", url = "localhost:8001/api/v1/alumno")
public interface AlumnoClientRest {

    @GetMapping("/{id}")
    public Alumnos findById(@PathVariable Long id);
}
