package com.edutech.msvc.alumnos.Cilent;

import com.edutech.msvc.alumnos.models.Evaluacion;
import com.edutech.msvc.alumnos.models.Inscripcion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-inscripcion", url = "localhost:8003/api/v1/inscripcion")
public interface InscripcionClientRest {
    @GetMapping("/{id}")
    List<Inscripcion> findByIdAlumno(@PathVariable Long id);
}
