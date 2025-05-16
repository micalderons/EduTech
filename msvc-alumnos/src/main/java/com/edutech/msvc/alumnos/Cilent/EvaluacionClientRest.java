package com.edutech.msvc.alumnos.Cilent;

import com.edutech.msvc.alumnos.models.Compra;
import com.edutech.msvc.alumnos.models.Evaluacion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "msvc-evaluacion", url = "localhost:8085/api/v1/evaluacion")
public interface EvaluacionClientRest {
    @GetMapping("/{id}")
    Evaluacion findById(@PathVariable Long id);
}
