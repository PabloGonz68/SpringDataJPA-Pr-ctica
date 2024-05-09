package com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository7;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity7.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
