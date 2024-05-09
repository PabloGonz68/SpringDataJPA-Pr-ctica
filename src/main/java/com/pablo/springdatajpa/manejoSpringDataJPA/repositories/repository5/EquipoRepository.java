package com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository5;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity5.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
