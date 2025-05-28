package com.edutech.msvc.cursos.controllers;

import com.edutech.msvc.cursos.models.entities.Curso;
import com.edutech.msvc.cursos.services.CursoService;
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
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> findAll(){
        List<Curso> cursos = this.cursoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id){
        Curso curso = this.cursoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(curso);
    }

    @PostMapping
    public ResponseEntity<Curso> save(@Valid @RequestBody Curso curso){
        Curso saved = this.cursoService.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
