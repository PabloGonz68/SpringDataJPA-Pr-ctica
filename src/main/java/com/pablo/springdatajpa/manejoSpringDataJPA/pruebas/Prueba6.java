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

        //Leer aerolinea desd el repository
        Aerolinea aerolineadesdeBD = aerolineaRepository.findById(aerolinea.getId()).orElse(null);
        if (aerolineadesdeBD!=null){
            System.out.println("Nombre de la aerolinea: "+aerolineadesdeBD.getNombre());

            //Eliminar aerolinea y sus vuelos
            aerolineaRepository.delete(aerolineadesdeBD);

            //Verificar eliminacion total
            List<Vuelo> vuelos = vueloRepository.findAll();
            System.out.println("Numero de vuelos en la base de datos: "+vuelos.size());

        }
    }
}
