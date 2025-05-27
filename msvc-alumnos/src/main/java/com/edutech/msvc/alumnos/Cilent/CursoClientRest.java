package com.edutech.msvc.alumnos.Cilent;

import com.edutech.msvc.alumnos.models.Curso;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "msvc-curso", url = "localhost:8002/api/v1/curso")
public interface CursoClientRest {
    @GetMapping("/{id}")
    Curso findById(@PathVariable Long id);
}
