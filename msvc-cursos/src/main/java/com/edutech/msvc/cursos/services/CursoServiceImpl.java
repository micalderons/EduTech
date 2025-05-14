package com.edutech.msvc.cursos.services;

import com.edutech.msvc.cursos.exception.CusoException;
import com.edutech.msvc.cursos.models.entities.Curso;
import com.edutech.msvc.cursos.repositories.CursoRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CursoServiceImpl implements CursoService{
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll(){ return this.cursoRepository.findAll();}

    @Override
    public Curso findById(Long id){
        return this.cursoRepository.findById(id).orElseThrow(
                () -> new CusoException("El paciente con id: " + id + " no se encuentra en la base de datos")
        );
    }

    @Override
    public Curso save(Curso curso){
        try{
            return this.cursoRepository.save(curso);
        }catch (FeignException ex){
            throw new CusoException(ex.getMessage());
        }
    }
}
