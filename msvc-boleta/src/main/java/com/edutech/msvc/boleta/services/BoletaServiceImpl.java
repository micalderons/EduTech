package com.edutech.msvc.boleta.services;

import com.edutech.msvc.boleta.clients.AlumnoClientRest;
import com.edutech.msvc.boleta.clients.CursoClientRest;
import com.edutech.msvc.boleta.clients.ProfesorClientRest;
import com.edutech.msvc.boleta.dtos.AlumnoDTO;
import com.edutech.msvc.boleta.dtos.BoletaDTO;
import com.edutech.msvc.boleta.dtos.CursoDTO;
import com.edutech.msvc.boleta.dtos.ProfesorDTO;
import com.edutech.msvc.boleta.exceptions.BoletaException;
import com.edutech.msvc.boleta.models.Alumno;
import com.edutech.msvc.boleta.models.Curso;
import com.edutech.msvc.boleta.models.Profesor;
import com.edutech.msvc.boleta.models.entities.Boleta;
import com.edutech.msvc.boleta.repositories.BoletaRepository;
import feign.FeignException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class BoletaServiceImpl implements BoletaService {

    @Autowired
    private BoletaRepository boletaRepository;

    @Autowired
    private AlumnoClientRest alumnoClientRest;

    @Autowired
    private CursoClientRest cursoClientRest;

    @Autowired
    private ProfesorClientRest profesorClientRest;

    @Override
    public List<BoletaDTO> findAll() {
        return this.boletaRepository.findAll().stream().map(boleta -> {

            Profesor profesor;
            try {
                profesor = this.profesorClientRest.findById(boleta.getIdProfesor());
            } catch (FeignException ex) {
                throw new BoletaException("El profesor no existe");
            }

            Alumno alumno;
            try {
                alumno = this.alumnoClientRest.findById(boleta.getIdAlumno());
            } catch (FeignException ex) {
                throw new BoletaException("El alumno no existe");
            }

            Curso curso;
            try {
                curso = this.cursoClientRest.findById(boleta.getIdCurso());
            } catch (FeignException ex) {
                throw new BoletaException("El curso no existe");
            }

            ProfesorDTO profesorDTO = new ProfesorDTO();
            profesorDTO.setRunProfesor(profesor.getRunProfesor());
            profesorDTO.setFechaNacimiento(profesor.getFechaNacimiento());
            profesorDTO.setNombreCompleto(profesor.getNombreCompleto());

            AlumnoDTO alumnoDTO = new AlumnoDTO();
            alumnoDTO.setRunAlumno(alumno.getRunAlumno());
            alumnoDTO.setFechaNacimiento(alumno.getFechaNacimiento());
            alumnoDTO.setNombreCompleto(alumno.getNombreCompleto());

            CursoDTO cursoDTO = new CursoDTO();
            cursoDTO.setNombreCurso(curso.getNombreCurso());
            cursoDTO.setDescripcionCurso(curso.getDescripcionCurso());

            BoletaDTO boletaDTO = new BoletaDTO();
            boletaDTO.setProfesor(profesorDTO);
            boletaDTO.setAlumno(alumnoDTO);
            boletaDTO.setCurso(cursoDTO);
            boletaDTO.setTotal(boleta.getTotal());
            boletaDTO.setFechaBoleta(boleta.getFechaBoleta());

            return boletaDTO;
        }).toList();
    }

    @Override
    public Boleta findById(Long id) {
        return this.boletaRepository.findById(id)
                .orElseThrow(() -> new BoletaException("La boleta con id " + id + " no se encuentra en la base de datos"));
    }

    @Override
    public Boleta save(Boleta boleta) {
        try {
            Profesor profesor = this.profesorClientRest.findById(boleta.getIdProfesor());
            if (profesor == null) throw new BoletaException("El profesor no existe");

            Alumno alumno = this.alumnoClientRest.findById(boleta.getIdAlumno());
            if (alumno == null) throw new BoletaException("El alumno no existe");

            Curso curso = this.cursoClientRest.findById(boleta.getIdCurso());
            if (curso == null) throw new BoletaException("El curso no existe");

        } catch (FeignException ex) {
            throw new BoletaException("Error al validar profesor, alumno o curso");
        }

        return this.boletaRepository.save(boleta);
    }

    @Override
    public List<Boleta> findByAlumnoId(Long alumnoId) {
        return this.boletaRepository.findByIdAlumno(alumnoId);
    }

    @Override
    public List<Boleta> findByProfesorId(Long profesorId) {
        return this.boletaRepository.findByIdProfesor(profesorId);
    }

    @Override
    public List<Boleta> findByCursoId(Long cursoId) {
        return this.boletaRepository.findByIdCurso(cursoId);
    }
}
