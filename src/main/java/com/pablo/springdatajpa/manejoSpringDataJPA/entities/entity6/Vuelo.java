/*
Resumen:
Esta clase representa la entidad Vuelo en el sistema, que está mapeada a una tabla en la base de datos mediante JPA. La clase utiliza anotaciones de Lombok para generar automáticamente constructores, getters, setters y otros métodos estándar. La tabla correspondiente tendrá columnas para el ID, el número de vuelo y el destino del vuelo. Además, esta clase tiene una relación @ManyToOne con la entidad Aerolinea, lo que significa que un vuelo pertenece a una única aerolínea. Se utiliza la anotación @JoinColumn para especificar la columna en la tabla de vuelos que hace referencia al ID de la aerolínea en la tabla de aerolíneas.

*/

package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity6;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.query.Param;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  int numVuelo;
    private String destino;

    @ManyToOne
    @JoinColumn(name = "aerolinea_id")
    private Aerolinea aerolinea;
}
