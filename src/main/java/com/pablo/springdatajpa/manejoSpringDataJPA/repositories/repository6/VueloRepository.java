package com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository6;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity6.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long>{
}
