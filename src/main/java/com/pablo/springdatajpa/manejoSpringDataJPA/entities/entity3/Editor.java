/*
Resumen:
Esta clase representa la entidad Editor en el sistema, que está mapeada a una tabla en la base de datos mediante JPA. La clase utiliza anotaciones de Lombok para generar automáticamente constructores, getters, setters y otros métodos estándar. La tabla correspondiente tendrá columnas para el ID y el nombre del editor. Además, esta clase tiene una relación @OneToMany con la entidad Revista, lo que significa que un editor puede tener varias revistas. La propiedad mappedBy indica que la relación es propiedad de la clase Revista y se mapea por el campo editor. Se utiliza la cascada ALL para que las operaciones de persistencia se propaguen a las revistas relacionadas. El FetchType.EAGER indica que las revistas deben cargarse de manera ansiosa (eager).

*/

package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity3;

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
public class Editor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    //mappedBy indica el dueño de la relacion
    //fetch hace referencia a la carga
    @OneToMany(mappedBy = "editor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Revista> revistas = new ArrayList<>();
}
