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
