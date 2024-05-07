package com.pablo.springdatajpa.manejoSpringDataJPA.pruebas;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity1.Direccion;
import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity1.Estudiante;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository1.DireccionRepository;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository1.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Prueba1 implements CommandLineRunner {
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public void run(String... args) throws Exception {
        Direccion direccion = new Direccion();//Crea Direccion y rellenara sus campos
        direccion.setCalle("2, Avenida Suarez");
        direccion.setCiudad("León");
        direccion.setCodigoPostal("45093");

        Estudiante estudiante = new Estudiante();//Crea Estudiante y rellenara sus campos
        estudiante.setNombre("Pedro");
        estudiante.setDireccion(direccion);//Rellena el campo de Estudiante con lo anterior de Direccion
        estudianteRepository.save(estudiante);//Guarda el estudiante en la BBDD

        estudiante.setNombre("PACO");//Actualiza el nombre
        estudianteRepository.save(estudiante);//Lo guarda en la BBDD

        Iterable<Estudiante> estudiantes = estudianteRepository.findAll();
        for(Estudiante e: estudiantes){//Recorrera la BBDD mostrando el nombre y direccion de cada estudiante
            System.out.println("Estudiante: "+e.getNombre()+" Dirección: "+e.getDireccion().getCalle());
        }
        estudianteRepository.delete(estudiante);//Elimina el estudiante recien creado
    }
}
