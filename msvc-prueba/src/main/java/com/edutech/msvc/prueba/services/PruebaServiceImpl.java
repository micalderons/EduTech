package com.edutech.msvc.prueba.services;


import com.edutech.msvc.prueba.exceptions.PruebaException;
import com.edutech.msvc.prueba.models.Profesor;
import com.edutech.msvc.prueba.models.Prueba;
import com.edutech.msvc.prueba.repositories.PruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PruebaServiceImpl implements PruebaService {

    @Autowired
    private PruebaRepository pruebaRepository;
    @Autowired
    private PruebaService pruebaService;

    @Override
    public List<Prueba> findAll(){
        return this.pruebaRepository.findAll();
    }

    @Override
    public Prueba findById(Long id){
        return this.pruebaRepository.findById(id).orElseThrow(
                () -> new PruebaException("La prueba con id "+id+"no se encuentra disponible")
        );
    }
    public Prueba save (Prueba prueba) {
        try {
            Profesor profesor = this elclientdeprofesor.findById()asdasd
        }
    }
}
