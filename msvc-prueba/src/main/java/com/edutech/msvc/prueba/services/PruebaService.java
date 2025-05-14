package com.edutech.msvc.prueba.services;

import com.edutech.msvc.prueba.models.Prueba;

import java.util.List;

public interface PruebaService {

    List<Prueba> findAll();
    Prueba findById(Long id);
    Prueba save(Prueba prueba);

}
