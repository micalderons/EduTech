package com.edutech.msvc_profesores.services;

import com.edutech.msvc_profesores.dtos.EstadoProfesorDTO;
import com.edutech.msvc_profesores.dtos.UpdateProfesorDTO;
import com.edutech.msvc_profesores.exception.ProfesorException;
import com.edutech.msvc_profesores.models.entities.Profesor;
import com.edutech.msvc_profesores.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfesorServicelmpl implements ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;
    @Override
    public List<Profesor> findAll() {return this.profesorRepository.findAll();}

    @Override
    public Profesor findById(Long id) {
        return this.profesorRepository.findById(id).orElseThrow(
                () -> new ProfesorException("El Profesor con Id"+ id +" no se encuntra el la base de datos")
        );
    }

    @Override
    public Profesor save(Profesor profesor) {
        return  this.profesorRepository.save(profesor);
    }

    @Override
    public Profesor updateById(Long id, UpdateProfesorDTO updateProfesorDTO){
        return profesorRepository.findById(id).map(profesor -> {
            profesor.setNombres(updateProfesorDTO.getNombres());
            profesor.setApellidos(updateProfesorDTO.getApellidos());
            profesor.setFechaNacimiento(updateProfesorDTO.getFechaNacimiento());
            profesor.setCorreo(updateProfesorDTO.getCorreo());
            profesor.setContraseña(updateProfesorDTO.getContraseña());
            return profesorRepository.save(profesor);
        }).orElseThrow(
                ()-> new ProfesorException("profesor con id "+id+" no encontrado")
        );
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Profesor cambiarEstadoCuenta(Long id, EstadoProfesorDTO estadoProfesorDTO) {
        return null;
    }
}
