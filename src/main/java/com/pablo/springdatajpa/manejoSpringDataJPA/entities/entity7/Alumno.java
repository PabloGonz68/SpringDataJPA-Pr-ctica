/*
Resumen:
Esta clase representa la entidad Alumno en el sistema, que está mapeada a una tabla en la base de datos mediante JPA. La clase utiliza anotaciones de Lombok para generar automáticamente constructores, getters, setters y otros métodos estándar. La tabla correspondiente tendrá columnas para el ID y el nombre del alumno. Además, esta clase tiene una relación @ManyToMany con la entidad Curso, lo que significa que un alumno puede estar inscrito en varios cursos y un curso puede tener varios alumnos. Se utiliza la tabla de unión "alumno_cursos" para almacenar esta relación, con columnas que hacen referencia a los IDs de alumno y curso respectivamente.

*/

package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity7;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relacion muchos a muchos
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "alumno_cursos",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private Set<Curso> cursos = new HashSet<>();
}
