package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity5;

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
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Jugador> jugadores = new ArrayList<>();
}
