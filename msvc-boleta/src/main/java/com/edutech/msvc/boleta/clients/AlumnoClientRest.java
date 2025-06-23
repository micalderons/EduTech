package com.edutech.msvc.boleta.clients;

import com.edutech.msvc.compra.model.Alumno;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-alumnos", url = "http://localhost:8020/api/v1/alumnos")
public interface AlumnoClientRest {

    @GetMapping("/{id}")
    Alumno findById(@PathVariable Long id);
}