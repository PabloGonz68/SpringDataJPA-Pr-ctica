package com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository1;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity1.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}
