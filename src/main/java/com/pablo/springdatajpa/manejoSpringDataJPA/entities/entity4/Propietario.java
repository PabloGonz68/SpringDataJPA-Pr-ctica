/*
Resumen:
Esta clase representa la entidad Propietario en el sistema, que está mapeada a una tabla en la base de datos mediante JPA. La clase utiliza anotaciones de Lombok para generar automáticamente constructores, getters, setters y otros métodos estándar. La tabla correspondiente tendrá columnas para el ID y el nombre del propietario. Además, esta clase tiene una relación @OneToOne con la entidad Automovil, lo que significa que un propietario tiene un único automóvil. La propiedad mappedBy indica que la relación está mapeada por el campo "propietario" en la clase Automovil. Se utiliza la cascada ALL para que las operaciones de persistencia se propaguen al automóvil relacionado. Además, se utiliza FetchType.LAZY para cargar perezosamente (lazy) el automóvil del propietario, lo que significa que el automóvil solo se cargará cuando sea necesario y no de forma automática.

*/

package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity4;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne(mappedBy = "propietario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Automovil automovil;
}
