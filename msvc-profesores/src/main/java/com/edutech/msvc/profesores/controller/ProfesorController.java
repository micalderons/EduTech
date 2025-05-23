package com.edutech.msvc.profesores.controller;

import com.edutech.msvc.profesores.dtos.EstadoProfesorDTO;
import com.edutech.msvc.profesores.dtos.UpdateProfesorDTO;
import com.edutech.msvc.profesores.models.entities.Profesor;
import com.edutech.msvc.profesores.services.ProfesorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/profesor")
@Validated
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public ResponseEntity<List<Profesor>> findAll() {
        List<Profesor> profesor = this.profesorService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(profesor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> findById(@PathVariable Long id) {
        Profesor profesor = this.profesorService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(profesor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        profesorService.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PostMapping
    public ResponseEntity<Profesor> save(@Valid @RequestBody Profesor profesor) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(profesorService.save(profesor));
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Profesor> update(@PathVariable Long id, @Valid @RequestBody UpdateProfesorDTO updateProfesorDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(profesorService.updateById(id,updateProfesorDTO));
    }
    @PutMapping("/{id}/Estadp")
    public  ResponseEntity<Profesor> estadoCuenta(@PathVariable Long id, @Valid @RequestBody EstadoProfesorDTO estadoDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(profesorService.cambiarEstadoCuenta(id,estadoDTO));
    }
}
