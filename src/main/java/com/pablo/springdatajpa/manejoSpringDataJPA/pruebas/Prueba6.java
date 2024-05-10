/*
Resumen:
Este código presenta un ejemplo de cómo utilizar Spring Data JPA para manejar entidades Aerolinea y Vuelo con una relación bidireccional @OneToMany - @ManyToOne, donde una aerolínea puede tener varios vuelos y un vuelo pertenece a una sola aerolínea. Se crea una aerolínea y dos vuelos, se les asigna a la aerolínea y se guardan en la base de datos. Luego se lee la aerolínea desde el repositorio, se elimina la aerolínea y se verifican los vuelos restantes en la base de datos.

*/

package com.pablo.springdatajpa.manejoSpringDataJPA.pruebas;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity6.Aerolinea;
import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity6.Vuelo;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository6.AerolineaRepository;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository6.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class Prueba6 implements CommandLineRunner {
    @Autowired
    private AerolineaRepository aerolineaRepository;

    @Autowired
    private VueloRepository vueloRepository;

    @Override
    public void run(String... args) throws Exception {
        //Crear aerolinea con vuelos
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setNombre("Vueling");

        Vuelo vuelo1 = new Vuelo();
        vuelo1.setNumVuelo(1);
        vuelo1.setDestino("Madrid");

        Vuelo vuelo2 = new Vuelo();
        vuelo2.setNumVuelo(2);
        vuelo2.setDestino("Roma");

        aerolinea.getVuelos().add(vuelo1);
        aerolinea.getVuelos().add(vuelo2);

        aerolineaRepository.save(aerolinea);

        //Leer aerolinea desde el repository
        Aerolinea aerolineadesdeBD = aerolineaRepository.findById(aerolinea.getId()).orElse(null);
        if (aerolineadesdeBD!=null){
            System.out.println("Nombre de la aerolínea: "+aerolineadesdeBD.getNombre());

            //Eliminar aerolinea y sus vuelos
            aerolineaRepository.delete(aerolineadesdeBD);

            //Verificar eliminación total
            List<Vuelo> vuelos = vueloRepository.findAll();
            System.out.println("Número de vuelos en la base de datos: "+vuelos.size());

        }
    }
}
