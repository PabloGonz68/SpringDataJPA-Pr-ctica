/*
Resumen:
Esta clase representa la entidad Automovil en el sistema, que está mapeada a una tabla en la base de datos mediante JPA. La clase utiliza anotaciones de Lombok para generar automáticamente constructores, getters, setters y otros métodos estándar. La tabla correspondiente tendrá columnas para el ID, la marca y el modelo del automóvil. Además, esta clase tiene una relación @OneToOne con la entidad Propietario, lo que significa que un automóvil pertenece a un único propietario. Se utiliza la anotación @JoinColumn para especificar la columna en la tabla de automóviles que hace referencia al ID del propietario en la tabla de propietarios. Además, se utiliza FetchType.LAZY para cargar perezosamente (lazy) el propietario del automóvil, lo que significa que el propietario solo se cargará cuando sea necesario y no de forma automática.

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
public class Automovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;
}
