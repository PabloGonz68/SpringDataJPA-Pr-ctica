/*
Resumen:
Esta clase representa la entidad Revista en el sistema, que está mapeada a una tabla en la base de datos mediante JPA. La clase utiliza anotaciones de Lombok para generar automáticamente constructores, getters, setters y otros métodos estándar. La tabla correspondiente tendrá columnas para el ID y el nombre de la revista. Además, esta clase tiene una relación @ManyToOne con la entidad Editor, lo que significa que una revista pertenece a un único editor. Se utiliza la anotación @JoinColumn para especificar la columna en la tabla de revistas que hace referencia al ID del editor en la tabla de editores.

*/

package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity3;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Revista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "editor_id")
    private Editor editor;

}
