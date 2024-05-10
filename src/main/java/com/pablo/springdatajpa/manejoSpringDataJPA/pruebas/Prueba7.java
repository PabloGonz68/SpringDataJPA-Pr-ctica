package com.pablo.springdatajpa.manejoSpringDataJPA.pruebas;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity7.Alumno;
import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity7.Curso;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository7.AlumnoRepository;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository7.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class Prueba7 implements CommandLineRunner {
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public void run(String... args) throws Exception {
        //Operaciones CRUD
        Alumno alumno1 = new Alumno();
        alumno1.setNombre("Juan");

        Alumno alumno2 = new Alumno();
        alumno2.setNombre("Ana");

        Curso curso1 = new Curso();
        curso1.setNombre("SpringBoot de 0 a experto");

        Curso curso2 = new Curso();
        curso2.setNombre("Aprende SpringJPA");

        alumno1.getCursos().add(curso1);
        alumno1.getCursos().add(curso2);
        alumno2.getCursos().add(curso1);

        alumno1 = alumnoRepository.save(alumno1);
        alumno2 = alumnoRepository.save(alumno2);

        //Búsqueda de alumno
        Alumno alumnoRecup = alumnoRepository.findById(alumno1.getId()).orElse(null);
        if (alumnoRecup != null) {
            System.out.println("Alumno recuperado: " + alumnoRecup.getNombre());
        }

        Curso cursoRecup = cursoRepository.findById(curso1.getId()).orElse(null);
        if (cursoRecup != null) {
            System.out.println("Curso recuperado: " + cursoRecup.getNombre());
        }

        //Eliminar estudiante por su ID
        if (alumnoRecup != null) {
            alumnoRepository.delete(alumnoRecup);
            System.out.println("Alumno eliminado");
        } else {
            System.out.println("No se encontró el alumno para eliminar");
        }

        //Eliminar curso por su ID
        if (cursoRecup != null) {
            cursoRepository.delete(cursoRecup);
            System.out.println("Curso eliminado");
        } else {
            System.out.println("No se encontró el curso para eliminar");
        }
    }

}
