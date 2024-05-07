package com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository2;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity2.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
