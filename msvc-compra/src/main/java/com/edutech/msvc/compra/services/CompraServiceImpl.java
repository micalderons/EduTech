package com.edutech.msvc.compra.services;

import com.edutech.msvc.compra.clients.AlumnoClientRest;
import com.edutech.msvc.compra.clients.CursoClientRest;
import com.edutech.msvc.compra.clients.ProfesorClientRest;
import com.edutech.msvc.compra.dtos.CompraDTO;
import com.edutech.msvc.compra.dtos.AlumnoDTO;
import com.edutech.msvc.compra.dtos.CursoDTO;
import com.edutech.msvc.compra.dtos.ProfesorDTO;
import com.edutech.msvc.compra.exceptions.CompraException;
import com.edutech.msvc.compra.model.Alumno;
import com.edutech.msvc.compra.model.Curso;
import com.edutech.msvc.compra.model.Profesor;
import com.edutech.msvc.compra.model.entity.Compra;
import com.edutech.msvc.compra.repositories.CompraRepository;
import feign.FeignException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProfesorClientRest profesorClientRest;

    @Autowired
    private AlumnoClientRest alumnoClientRest;

    @Autowired
    private CursoClientRest cursoClientRest;

    @Override
    public List<CompraDTO> findAll() {
        return this.compraRepository.findAll().stream().map(compra -> {

            Profesor profesor;
            try {
                profesor = this.profesorClientRest.findById(compra.getIdProfesor());
            } catch (FeignException ex) {
                throw new CompraException("El profesor buscado no existe");
            }

            Alumno alumno;
            Curso curso;
            try {
                alumno = this.alumnoClientRest.findById(compra.getIdAlumno());
                curso = this.cursoClientRest.findById(compra.getIdCurso());
            } catch (FeignException ex) {
                throw new CompraException("El alumno o el curso no existe en la base de datos");
            }

            ProfesorDTO profesorDTO = new ProfesorDTO();
            profesorDTO.setRunProfesor(profesor.getRunProfesor());
            profesorDTO.setNombreCompleto(profesor.getNombreCompleto());
            profesorDTO.setFechaNacimiento(profesor.getFechaNacimiento());
            profesorDTO.setEstadoCuenta(profesor.isEstadoCuenta());

            AlumnoDTO alumnoDTO = new AlumnoDTO();
            alumnoDTO.setRunAlumno(alumno.getRunAlumno());
            alumnoDTO.setNombreCompleto(alumno.getNombreCompleto());
            alumnoDTO.setFechaNacimiento(alumno.getFechaNacimiento());
            alumnoDTO.setEstadoCuenta(alumno.isEstadoCuenta());

            CursoDTO cursoDTO = new CursoDTO();
            cursoDTO.setIdCurso(curso.getIdCurso());
            cursoDTO.setNombreCurso(curso.getNombreCurso());
            cursoDTO.setPrecioCurso(curso.getPrecioCurso());
            cursoDTO.setDescripcionCurso(curso.getDescripcionCurso());

            CompraDTO compraDTO = new CompraDTO();
            compraDTO.setProfesor(profesorDTO);
            compraDTO.setAlumno(alumnoDTO);
            compraDTO.setCurso(cursoDTO);

            return compraDTO;
        }).toList();
    }

    @Override
    public Compra findById(Long id) {
        return this.compraRepository.findById(id).orElseThrow(
                () -> new CompraException("La compra con id: " + id + " no se encuentra en la base de datos")
        );
    }

    @Override
    public Compra save(Compra compra) {
        try {
            this.alumnoClientRest.findById(compra.getIdAlumno());
            Curso curso = this.cursoClientRest.findById(compra.getIdCurso());
            this.profesorClientRest.findById(compra.getIdProfesor());

            int precioTotal = curso.getPrecioCurso() * compra.getCantidad();
            compra.setPrecioTotal(precioTotal);

        } catch (FeignException ex) {
            throw new CompraException("Problemas con la asociación profesor, alumno o curso");
        }
        return this.compraRepository.save(compra);
    }

    @Override
    public List<Compra> findByProfesorId(Long profesorId) {
        return this.compraRepository.findByIdProfesor(profesorId);
    }

    @Override
    public List<Compra> findByAlumnoId(Long alumnoId) {
        return this.compraRepository.findByIdAlumno(alumnoId);
    }
}
