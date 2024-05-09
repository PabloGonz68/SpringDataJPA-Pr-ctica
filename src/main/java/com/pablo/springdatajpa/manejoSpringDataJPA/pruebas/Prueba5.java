package com.pablo.springdatajpa.manejoSpringDataJPA.pruebas;


import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity5.Equipo;
import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity5.Jugador;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository5.EquipoRepository;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository5.JugadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class Prueba5 implements CommandLineRunner {

    @Autowired
    EquipoRepository equipoRepository;


    @Override
    public void run(String... args) throws Exception {
        Equipo equipo = new Equipo();
        equipo.setNombre("Real Madrid");

        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Vinicius JR");
        jugador1.setDorsal(7);

        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Dani Carvajal");
        jugador2.setDorsal(2);

        equipo.getJugadores().add(jugador1);
        equipo.getJugadores().add(jugador2);

        equipoRepository.save(equipo);

        //Leer equipo y jugadores
        Equipo equipoGuardado = equipoRepository.findById(equipo.getId()).orElse(null);
        if (equipoGuardado!=null){
            System.out.println("Equipo: "+equipoGuardado.getNombre());
            System.out.println("Jugadores del equipo(USANDO LAZY): ");
            for (Jugador jugador: equipoGuardado.getJugadores()){
                System.out.println("-"+jugador.getNombre()+", Dorsal: "+jugador.getDorsal());
            }
        }
        //Actualización y eliminación
        if (equipoGuardado!=null){
            //Actualizar jugador en el equipo
            Jugador jugadorActualizado = equipoGuardado.getJugadores().get(0);
            jugadorActualizado.setDorsal(5);

            //No es necesario guardar otra vez el equipo ya que las actualizaciones on automaticas por el CascadeType.Merge
            //Leer de nuevo equipo y jugadores
            Equipo equipoActualizado = equipoRepository.findById(equipo.getId()).orElse(null);
            if (equipoActualizado!=null){
                System.out.println("Equipo actualizado: "+equipoActualizado.getNombre());
                System.out.println("Jugadores actualizados: ");
                for(Jugador jugador: equipoActualizado.getJugadores()){
                    System.out.println("-"+jugador.getNombre()+", Dorsal: "+jugador.getDorsal());
                }
                //Eliminar un jugador del equipo
                equipoActualizado.getJugadores().remove(1);

                equipoRepository.delete(equipoActualizado);
            }
        }
        //Verificamos si se ha eliminado
        Equipo equipoEliminado = equipoRepository.findById(equipo.getId()).orElse(null);
        if (equipoEliminado!=null){
            System.out.println("Equipo eliminado con éxito");
        }
    }
}