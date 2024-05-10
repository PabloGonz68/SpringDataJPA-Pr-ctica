/*
Resumen:
Esta clase representa la entidad Estudiante en el sistema, que está mapeada a una tabla en la base de datos mediante JPA. La clase utiliza anotaciones de Lombok para generar automáticamente constructores, getters, setters y otros métodos estándar. La tabla correspondiente tendrá columnas para el ID y el nombre del estudiante, así como una columna para la clave externa (foreign key) que hace referencia al ID de la dirección del estudiante.

*/

package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Autoincremental
    private Long id;

    private String nombre;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})//Relación 1 a 1 y cascada tipo Persist para Insertar/Actualizar y Remove para borrar las tablas hijas tambien
    @JoinColumn(name = "direccionId", referencedColumnName = "id")//se crea la columna donde se guardara y se hace el REFERENCES
    private Direccion direccion;//se usa el objeto de la clase
}
