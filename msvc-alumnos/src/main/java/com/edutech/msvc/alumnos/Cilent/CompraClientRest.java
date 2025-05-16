package com.edutech.msvc.alumnos.Cilent;

import com.edutech.msvc.alumnos.models.Compra;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-compra", url = "localhost:8083/api/v1/compra")
public interface CompraClientRest {

    @GetMapping("/{id}")
    Compra findById(@PathVariable Long id);
}
