package com.edutech.msvc.prueba.clients;

import com.edutech.msvc.prueba.models.Profesores;
import com.edutech.msvc.prueba.models.entities.Prueba;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-profesor", url = "localhost:8081/api/v1/profesor" )
public interface ProfesorClientRest {

    @GetMapping
    List<Profesores> findAll();

    @GetMapping("/{id}")
    Profesores findById(@PathVariable Long id);
}
