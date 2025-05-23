package com.edutech.msvc.prueba.controller;

import com.edutech.msvc.prueba.dtos.PruebaDTO;
import com.edutech.msvc.prueba.models.entities.Prueba;
import com.edutech.msvc.prueba.services.PruebaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prueba")
@Validated
public class PruebaController {

    @Autowired
    private PruebaService pruebaService;

    @GetMapping
    public ResponseEntity<List<PruebaDTO>>findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.pruebaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Prueba>> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.pruebaService.findByIdCurso(id));
    }

    @PostMapping
    public ResponseEntity<Prueba> save(@RequestBody @Valid Prueba prueba){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.pruebaService.save(prueba));
    }

     @GetMapping("/profesor/{id}")
    public ResponseEntity<List<Prueba>> findByIdProfesor(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.pruebaService.findByIdProfesor(id));
     }

     @GetMapping("/cursos/{id}")
    public ResponseEntity<List<Prueba>> findByIdCurso(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.pruebaService.findByIdCurso(id));
     }


}
