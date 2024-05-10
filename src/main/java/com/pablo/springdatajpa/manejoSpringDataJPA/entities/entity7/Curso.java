/*
Resumen:
Esta clase representa la entidad Curso en el sistema, que está mapeada a una tabla en la base de datos mediante JPA. La clase utiliza anotaciones de Lombok para generar automáticamente constructores, getters, setters y otros métodos estándar. La tabla correspondiente tendrá columnas para el ID y el nombre del curso. Además, esta clase tiene una relación @ManyToMany con la entidad Alumno, lo que significa que un curso puede tener varios alumnos y un alumno puede estar inscrito en varios cursos. Esta relación se mapea utilizando la propiedad mappedBy en la entidad Alumno, lo que indica que la entidad Curso no es la dueña de la relación y que la configuración de la relación está definida en la entidad Alumno.

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
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "cursos")
    private Set<Alumno> alumnos = new HashSet<>();
}
