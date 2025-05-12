package com.edutech.msvc.alumnos.servicies;

import com.edutech.msvc.alumnos.exception.AlumnoException;
import com.edutech.msvc.alumnos.models.entities.Alumno;
import com.edutech.msvc.alumnos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServicelmpl implements AlumnoService{
 @Autowired
 private UsuarioRepository usuarioRepository;

 @Override
  public List<Alumno> findAll(){ return this.usuarioRepository.findAll();}

 @Override
 public Alumno findById(Long id){
  return this.usuarioRepository.findById(id).orElseThrow(
          () -> new AlumnoException("El Paciente con Id"+ id +" no se encuntra el la base de datos")
  );

 }

 @Override
 public Alumno save(Alumno alumno) {
  return  this.usuarioRepository.save(alumno);
 }
}
