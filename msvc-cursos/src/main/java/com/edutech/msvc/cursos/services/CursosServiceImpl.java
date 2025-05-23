package com.edutech.msvc.cursos.services;

import com.edutech.msvc.cursos.exception.CusosException;
import com.edutech.msvc.cursos.models.entities.Cursos;
import com.edutech.msvc.cursos.repositories.CursosRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CursosServiceImpl implements CursosService {
    @Autowired
    private CursosRepository cursosRepository;

    @Override
    public List<Cursos> findAll(){ return this.cursosRepository.findAll();}

    @Override
    public Cursos findById(Long id){
        return this.cursosRepository.findById(id).orElseThrow(
                () -> new CusosException("El paciente con id: " + id + " no se encuentra en la base de datos")
        );
    }

    @Override
    public Cursos save(Cursos curso){
        try{
            return this.cursosRepository.save(curso);
        }catch (FeignException ex){
            throw new CusosException(ex.getMessage());
        }
    }
}
