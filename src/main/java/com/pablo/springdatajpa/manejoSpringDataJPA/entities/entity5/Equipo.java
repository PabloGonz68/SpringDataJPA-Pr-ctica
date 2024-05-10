/*
Resumen:
Esta clase representa la entidad Equipo en el sistema, que está mapeada a una tabla en la base de datos mediante JPA. La clase utiliza anotaciones de Lombok para generar automáticamente constructores, getters, setters y otros métodos estándar. La tabla correspondiente tendrá columnas para el ID y el nombre del equipo. Además, esta clase tiene una relación @OneToMany con la entidad Jugador, lo que significa que un equipo puede tener varios jugadores. La propiedad mappedBy indica que la relación está mapeada por el campo "equipo" en la clase Jugador. Se utiliza la cascada MERGE para que las operaciones de persistencia se propaguen a los jugadores relacionados. Además, se utiliza FetchType.LAZY para cargar perezosamente (lazy) los jugadores del equipo, lo que significa que los jugadores solo se cargarán cuando sea necesario y no de forma automática.

*/

package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity5;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Jugador> jugadores = new ArrayList<>();
}
