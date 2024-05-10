/*
Resumen:
Esta clase representa la entidad Autor en el sistema, que está mapeada a una tabla en la base de datos mediante JPA. La clase utiliza anotaciones de Lombok para generar automáticamente constructores, getters, setters y otros métodos estándar. La tabla correspondiente tendrá columnas para el ID y el nombre del autor. Además, esta clase tiene una relación @OneToMany con la entidad Libro, lo que significa que un autor puede tener varios libros. Se utiliza la cascada ALL para que las operaciones de persistencia se propaguen a los libros relacionados.

*/

package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity2;

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
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private List<Libro> libros = new ArrayList<>();
}
