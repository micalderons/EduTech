package com.edutech.msvc.profesores.client;

import com.edutech.msvc.profesores.models.Pruebas;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "msvc-prueba", url = "localhost:8006/api/v1/prueba")
public interface PruebaClientRest {
    @GetMapping("/{id}")
    Pruebas findById(@PathVariable Long id);
}
