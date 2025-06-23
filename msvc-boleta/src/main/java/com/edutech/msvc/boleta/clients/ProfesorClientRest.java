package com.edutech.msvc.boleta.clients;

import com.edutech.msvc.boleta.models.Profesor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-profesores", url = "http://localhost:8088/api/v1/profesores")
public interface ProfesorClientRest {

    @GetMapping("/{id}")
    Profesor findById(@PathVariable Long id);
}
