/*
Resumen:
Esta clase representa la entidad Direccion en el sistema, que está mapeada a una tabla en la base de datos mediante JPA. La clase utiliza anotaciones de Lombok para generar automáticamente constructores, getters, setters y otros métodos estándar. La tabla correspondiente tendrá columnas para el ID, calle, ciudad y código postal de una dirección.

*/

package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private String ciudad;
    private String codigoPostal;

}
