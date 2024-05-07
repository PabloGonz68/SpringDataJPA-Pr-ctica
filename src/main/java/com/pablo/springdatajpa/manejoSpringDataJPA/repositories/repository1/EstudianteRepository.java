package com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository1;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity1.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
