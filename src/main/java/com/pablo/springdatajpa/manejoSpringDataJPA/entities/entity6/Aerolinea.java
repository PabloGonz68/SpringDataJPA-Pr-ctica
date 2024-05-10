/*
Resumen:
Esta clase representa la entidad Aerolinea en el sistema, que está mapeada a una tabla en la base de datos mediante JPA. La clase utiliza anotaciones de Lombok para generar automáticamente constructores, getters, setters y otros métodos estándar. La tabla correspondiente tendrá columnas para el ID y el nombre de la aerolínea. Además, esta clase tiene una relación @OneToMany con la entidad Vuelo, lo que significa que una aerolínea puede tener varios vuelos. La propiedad mappedBy indica que la relación está mapeada por el campo "aerolinea" en la clase Vuelo. Se utiliza la cascada REMOVE para que las operaciones de persistencia se propaguen a los vuelos relacionados y se eliminen si se elimina la aerolínea.

*/

package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity6;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Entity
@Data
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "aerolinea", cascade = CascadeType.REMOVE)
    private List<Vuelo> vuelos = new ArrayList<>();

    public Aerolinea(){
        this.vuelos= new ArrayList<>();
    }

}
