package com.edutech.msvc.alumnos.controller;

import com.edutech.msvc.alumnos.dtos.EstadoDTO;
import com.edutech.msvc.alumnos.models.entities.Alumno;
import com.edutech.msvc.alumnos.services.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumno")
@Validated
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> findAll() {
        List<Alumno> alumnos = this.alumnoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(alumnos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> findById(@PathVariable Long id) {
        Alumno alumno = this.alumnoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(alumno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        alumnoService.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PostMapping
    public ResponseEntity<Alumno> save(@Valid @RequestBody Alumno alumno) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(alumnoService.save(alumno));
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Alumno> estadoCuenta(@PathVariable Long id, @Valid @RequestBody EstadoDTO estadoDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(alumnoService.cambiarEstadoCuenta(id,estadoDTO));
    }

}
