package com.edutech.msvc.evaluaciones.clients;

import com.edutech.msvc.evaluaciones.models.Prueba;
import com.edutech.msvc.evaluaciones.models.entities.Evaluacion;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-nota", url = "localhost:8082/api/v1/nota")
public interface PruebaClientRest {
    @GetMapping
    List<Evaluacion> findAll();

    @GetMapping("/{id}")
    Prueba findById(@PathVariable Long id);

    Prueba findById(@NotEmpty(message = "El curso no puede ser vacio") String idPrueba);
}
