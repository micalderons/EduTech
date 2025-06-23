package com.edutech.msvc.compra.controller;

import com.edutech.msvc.compra.dtos.CompraDTO;
import com.edutech.msvc.compra.model.entity.Compra;
import com.edutech.msvc.compra.services.CompraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public ResponseEntity<List<CompraDTO>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.compraService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.compraService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Compra> save(@RequestBody @Valid Compra compra) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.compraService.save(compra));
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<List<Compra>> findByIdAlumno(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.compraService.findByAlumnoId(id));
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<List<Compra>> findByIdCurso(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.compraService.findByCursoId(id));
    }
}
