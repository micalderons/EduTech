package com.edutech.msvc.boleta.controllers;

import com.edutech.msvc.boleta.dtos.BoletaDTO;
import com.edutech.msvc.boleta.models.entities.Boleta;
import com.edutech.msvc.boleta.services.BoletaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boletas")
@Validated
public class BoletaController {

    @Autowired
    private BoletaService boletaService;

    @GetMapping
    public ResponseEntity<List<BoletaDTO>> findAll() {
        return ResponseEntity.status(200).body(this.boletaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boleta> findById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(this.boletaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Boleta> save(@RequestBody @Valid Boleta boleta) {
        return ResponseEntity.status(201).body(this.boletaService.save(boleta));
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<List<Boleta>> findByAlumnoId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(this.boletaService.findByAlumnoId(id));
    }

    @GetMapping("/profesor/{id}")
    public ResponseEntity<List<Boleta>> findByProfesorId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(this.boletaService.findByProfesorId(id));
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<List<Boleta>> findByCursoId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(this.boletaService.findByCursoId(id));
    }
}
