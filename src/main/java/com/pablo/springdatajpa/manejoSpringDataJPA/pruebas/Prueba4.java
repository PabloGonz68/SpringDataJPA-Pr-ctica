package com.pablo.springdatajpa.manejoSpringDataJPA.pruebas;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity4.Automovil;
import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity4.Propietario;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository4.AutomovilRepository;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository4.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Prueba4 implements CommandLineRunner {

    @Autowired
    private PropietarioRepository propietarioRepository;
    @Autowired
    private AutomovilRepository automovilRepository;

    @Override
    public void run(String... args) throws Exception {
        Propietario propietario = new Propietario();
        propietario.setNombre("Celia");

        Automovil automovil = new Automovil();
        automovil.setMarca("Honda");
        automovil.setModelo("CRV");
        propietario.setAutomovil(automovil);
        automovil.setPropietario(propietario);

        propietarioRepository.save(propietario);
       // automovilRepository.save(automovil);

        //Leer propietario
        Long propietarioId = propietario.getId();
        Propietario propietarioLeido = propietarioRepository.findById(propietarioId).orElse(null);
        if(propietarioLeido!=null){
            System.out.println("Propietario Leido: "+propietarioLeido.getNombre());
        }

        //Actualizar automovil de un propietario
        Automovil automovilUpdate = propietario.getAutomovil();
        automovilUpdate.setMarca("Seat");
        automovilUpdate.setModelo("León");
        automovilRepository.save(automovilUpdate);

        //Eliminar propietario y sus automoviles
        propietarioRepository.delete(propietario);

        //Verificar si ha sido eliminado
        Propietario propietarioDelete = propietarioRepository.findById(propietarioId).orElse(null);
        if(propietarioDelete==null){
            System.out.println("Propietario eliminado con exito");
        }
    }


}
