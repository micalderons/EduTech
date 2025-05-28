package com.edutech.msvc.alumnos.Cilent;

import com.edutech.msvc.alumnos.models.Evaluacion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "msvc-inscripcion", url = "localhost:8004/api/v1/inscripcion")
public interface InscripccionClientRest {
    @GetMapping("/{id}")
    Evaluacion findById(@PathVariable Long id);
}
