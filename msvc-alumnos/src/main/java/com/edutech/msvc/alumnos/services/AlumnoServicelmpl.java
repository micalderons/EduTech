package com.edutech.msvc.alumnos.services;

import com.edutech.msvc.alumnos.Cilent.CursoClientRest;
import com.edutech.msvc.alumnos.Cilent.InscripcionClientRest;
import com.edutech.msvc.alumnos.dtos.CursoDTO;
import com.edutech.msvc.alumnos.dtos.EstadoDTO;
import com.edutech.msvc.alumnos.dtos.InscripcionAlumnoDTO;
import com.edutech.msvc.alumnos.exception.AlumnoException;
import com.edutech.msvc.alumnos.models.Curso;
import com.edutech.msvc.alumnos.models.Inscripcion;
import com.edutech.msvc.alumnos.models.entities.Alumno;
import com.edutech.msvc.alumnos.repositories.AlumnoRepository;
import com.edutech.msvc.alumnos.dtos.UpdateAlumnoDTO;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServicelmpl implements AlumnoService{
 @Autowired
 private AlumnoRepository usuarioRepository;

 @Autowired
 private InscripcionClientRest inscripcionClientRest;

 @Autowired
 private CursoClientRest cursoClientRest;

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
 @Override
 public Alumno updateById(Long id ,UpdateAlumnoDTO updateAlumnoDTO) {
  return usuarioRepository.findById(id).map(alumno -> {
   alumno.setNombres(updateAlumnoDTO.getNombres());
   alumno.setApellidos(updateAlumnoDTO.getApellidos());
   alumno.setFechaNacimiento(updateAlumnoDTO.getFechaNacimiento());
   alumno.setCorreo(updateAlumnoDTO.getCorreo());
   alumno.setContraseña(updateAlumnoDTO.getContraseña());
   return usuarioRepository.save(alumno);
  }).orElseThrow(
          ()-> new AlumnoException("Alumno con id "+id+" no encontrado")
  );
 }

 @Override
 public void delete(Long id) {
   usuarioRepository.deleteById(id);
 }

 @Override
 public Alumno cambiarEstadoCuenta(Long id, EstadoDTO estadoDTO) {
   return usuarioRepository.findById(id).map(alumno -> {
    alumno.setCuentaActiva(estadoDTO.getCuentaActiva());
    return usuarioRepository.save(alumno);
   }).orElseThrow(
           ()-> new AlumnoException("Alumno con id "+id+" no encontrado")
   );
 }

 @Override
 public List<InscripcionAlumnoDTO> findInscripcionesById(Long alumnoId){
  Alumno alumno = this.findById(alumnoId);

  List<Inscripcion> inscripciones = this.inscripcionClientRest.findByIdAlumno(alumno.getIdUsuario());

  if(!inscripciones.isEmpty()){
   return inscripciones.stream().map(inscripcion -> {
    InscripcionAlumnoDTO inscripcionAlumnoDTO = new InscripcionAlumnoDTO();
    Curso curso = null;
    try {
     curso = this.cursoClientRest.findById(inscripcion.getIdCurso());
    }catch (FeignException ex){
     throw new AlumnoException("Al momento de generar el listado de inscripciones de alumnos se" +
             " encontro que el curso con id " + inscripcion.getIdCurso() + " no existe");
    }
    CursoDTO cursoDTO = new CursoDTO();
    cursoDTO.setNombre(curso.getNombre());
    cursoDTO.setDuracion(curso.getDuracion());
    cursoDTO.setComentario(curso.getComentario());
    cursoDTO.setPrecio(curso.getPrecio());
    cursoDTO.setFechaCreacion(curso.getFechaCreacion());

    inscripcionAlumnoDTO.setFechaInscripcion(inscripcion.getFechaInscripcion());
    inscripcionAlumnoDTO.setCurso(cursoDTO);

    return inscripcionAlumnoDTO;

   }).toList();
  }
  return List.of();
 }
}
