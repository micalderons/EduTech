package com.edutech.msvc.evaluaciones.controllers;

import com.edutech.msvc.evaluaciones.dtos.EvaluacionDTO;
import com.edutech.msvc.evaluaciones.models.entities.Evaluacion;
import com.edutech.msvc.evaluaciones.services.EvaluacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/evaluaciones")
@Validated
public class EvaluacionController {

    @Autowired
    private EvaluacionesService evaluacionesService;

    @GetMapping
    public ResponseEntity<List<EvaluacionDTO>> findAll(){
        List<EvaluacionDTO> evaluacion = this.evaluacionesService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.evaluacionesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> findById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.evaluacionesService.findById(id));
    }

    @PostMapping
    public ResponseEntity <Evaluacion> save (@RequestBody @Validated Evaluacion evaluacion){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.evaluacionesService.save(evaluacion));
    }

    @GetMapping("/alumnos/{id}")
    public ResponseEntity<List<Evaluacion>> findByAlumno(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.evaluacionesService.findByIdAlumno(id));
    }
    @GetMapping("/prueba/{id}")
    public ResponseEntity<List<Evaluacion>> findByPrueba(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.evaluacionesService.findByIdPrueba(id));
    }
}
