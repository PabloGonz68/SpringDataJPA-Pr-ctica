package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity5;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int dorsal;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
        private  Equipo equipo;
}
