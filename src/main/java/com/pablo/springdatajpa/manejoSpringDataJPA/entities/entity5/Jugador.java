/*
Resumen:
Esta clase representa la entidad Jugador en el sistema, que está mapeada a una tabla en la base de datos mediante JPA. La clase utiliza anotaciones de Lombok para generar automáticamente constructores, getters, setters y otros métodos estándar. La tabla correspondiente tendrá columnas para el ID, el nombre y el dorsal del jugador. Además, esta clase tiene una relación @ManyToOne con la entidad Equipo, lo que significa que un jugador pertenece a un único equipo. Se utiliza la anotación @JoinColumn para especificar la columna en la tabla de jugadores que hace referencia al ID del equipo en la tabla de equipos.

*/

package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity5;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int dorsal;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private  Equipo equipo;
}
