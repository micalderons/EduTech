package com.edutech.msvc.inscripcion.controllers;

import com.edutech.msvc.inscripcion.dtos.InscripcionDTO;
import com.edutech.msvc.inscripcion.models.entities.Inscripcion;
import com.edutech.msvc.inscripcion.services.InscripcionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inscripciones")
@Validated
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public ResponseEntity<List<InscripcionDTO>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.inscripcionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.inscripcionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Inscripcion> save(@RequestBody @Valid Inscripcion inscripcion) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.inscripcionService.save(inscripcion));
    }

    // Estos metodos permiten mostrar las Inscripciones filtradas para un Alumno

    @GetMapping("/alumno/{id}")
    public ResponseEntity<List<Inscripcion>> findByIdAlumno(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.inscripcionService.findByAlumnoId(id));
    }

    // Estos metodos permiten mostrar las inscripciones filtradas para un curso

    @GetMapping("/cursos/{id}")
    public ResponseEntity<List<Inscripcion>> findByIdCurso(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.inscripcionService.findByCursoId(id));
    }
}
