package com.edutech.msvc.cursos.controller;

import com.edutech.msvc.cursos.models.entities.Cursos;
import com.edutech.msvc.cursos.services.CursosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
@Validated
public class CursosController {

    @Autowired
    private CursosService cursoService;

    @GetMapping
    public ResponseEntity<List<Cursos>> findAll(){
        List<Cursos> cursos = this.cursoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cursos> findById(@PathVariable Long id){
        Cursos curso = this.cursoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(curso);
    }

    @PostMapping
    public ResponseEntity<Cursos> save(@Valid @RequestBody Cursos curso){
        Cursos saved = this.cursoService.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
