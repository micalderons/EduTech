package com.edutech.msvc.evaluaciones.clients;

import com.edutech.msvc.evaluaciones.models.Nota;
import com.edutech.msvc.evaluaciones.models.Prueba;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-nota", url = "localhost:8082/api/v1/nota")
public interface NotaClientRest {
    @GetMapping
    List<Nota> findAll();

    @GetMapping("/{id}")
    Nota findById(@PathVariable Long id);
}
