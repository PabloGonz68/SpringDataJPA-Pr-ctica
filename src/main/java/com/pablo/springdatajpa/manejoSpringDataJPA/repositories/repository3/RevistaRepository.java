package com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository3;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity3.Revista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, Long> {
}
