package com.edutech.msvc.evaluaciones.services;

import com.edutech.msvc.evaluaciones.exceptions.EvaluacionException;
import com.edutech.msvc.evaluaciones.models.Alumno;
import com.edutech.msvc.evaluaciones.models.Nota;
import com.edutech.msvc.evaluaciones.repositories.EvaluacionesRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EvaluacionesServiceImpl implements EvaluacionesService{

    @Autowired
    private EvaluacionesRepository evaluacionesRepository;

    @Autowired
    private EvaluacionesService evaluacionesService;

    @Transactional(readOnly = true)
    @Override
    public List<Nota> findAll(){ return  this.evaluacionesRepository.findAll();}

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @Override
    public Nota findById(Long id){
        return this.evaluacionesRepository.findById(id).orElseThrow(
                ()-> new EvaluacionException("Nota con id "+id+"no encontrada")
        );
    }

    @Override
    public Nota save(Nota nota) {
        return null;
    }


}
