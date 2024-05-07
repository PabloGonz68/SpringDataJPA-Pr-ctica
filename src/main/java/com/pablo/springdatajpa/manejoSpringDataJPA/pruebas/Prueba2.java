package com.pablo.springdatajpa.manejoSpringDataJPA.pruebas;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity2.Autor;
import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity2.Libro;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository2.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Prueba2 implements CommandLineRunner {
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void run(String... args) throws Exception {
        //Creamos el autor
        Autor autor = new Autor();
        autor.setNombre("Marina");

        //Crear libros y agregarlos al autor
        Libro libro1 = new Libro();
        libro1.setTitulo("El gato con botas");
        Libro libro2 = new Libro();
        libro2.setTitulo("Habitos atómicos");

        autor.getLibros().add(libro1);
        autor.getLibros().add(libro2);
        //Guardar autor y los libros automaticamente por tener Cascade tipo ALL
        autorRepository.save(autor);

        Optional<Autor> autorGuardado = autorRepository.findById(autor.getId());
        autorGuardado.ifPresent(a ->{
            System.out.println("Autor leido por ID: "+ a.getNombre());
            a.setNombre("Laura");
            autorRepository.save(a);
            System.out.println("Autor Actualizado: "+ a.getNombre());
        });

        List<Autor> autores = autorRepository.findAll();
        System.out.println("Lista de autores: ");
        for(Autor a:autores){
            System.out.println("-" + a.getNombre());
        }
        autorRepository.delete(autor);
        System.out.println("Autor Eliminado");

    }
}
