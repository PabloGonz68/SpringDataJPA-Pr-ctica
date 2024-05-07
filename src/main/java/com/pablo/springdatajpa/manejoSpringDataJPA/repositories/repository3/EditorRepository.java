package com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository3;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity3.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long> {
}
