package com.edutech.msvc.cursos.clients;

import com.edutech.msvc.cursos.models.Alumno;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-alumnos", url = "localhost:8001/api/v1/alumno")
public interface AlumnoClientRest {

    @GetMapping("/{id}")
    Alumno findById(@PathVariable Long id);
}
