package com.edutech.msvc.prueba.repositories;

import com.edutech.msvc.prueba.models.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long> {
}
