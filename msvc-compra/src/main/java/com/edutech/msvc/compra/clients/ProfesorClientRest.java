package com.edutech.msvc.compra.clients;

import com.edutech.msvc.compra.model.Profesor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-profesores", url = "http://localhost:8087/api/v1/profesores")
public interface ProfesorClientRest {

    @GetMapping("/{id}")
    Profesor findById(@PathVariable("id") Long id);
}
