/*
Resumen:
Este código muestra un ejemplo de cómo utilizar Spring Data JPA para manejar entidades Estudiante y Direccion, con una relación @OneToOne. Se crea una instancia de Direccion y Estudiante, se establece la dirección para el estudiante, se guardan en la base de datos, se actualiza el nombre del estudiante, se recuperan todos los estudiantes de la base de datos y se muestra su nombre y dirección. Finalmente, se elimina el estudiante recién creado.
*/

package com.pablo.springdatajpa.manejoSpringDataJPA.pruebas;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity1.Direccion;
import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity1.Estudiante;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository1.DireccionRepository;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository1.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component //Esta comentada para que funcionen las otras pruebas
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
