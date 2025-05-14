package com.edutech.msvc.prueba.clients;

import com.edutech.msvc.prueba.models.Prueba;
import com.edutech.msvc.prueba.services.PruebaService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient (name= "mscv-prueba", url = "localhost:8082/api/v1/prueba")
public interface PruebaClientRest {

    @GetMapping
    List<Prueba> findAll();

    @GetMapping("/{id]")
    Prueba findById(@PathVariable Long id);
}
