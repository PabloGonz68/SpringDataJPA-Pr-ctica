package com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository5;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity5.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}
