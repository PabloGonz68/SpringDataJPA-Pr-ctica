package com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity3;

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
public class Editor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    //mappedBy indica el dueño de la relacion
    //fetch hace referencia a la carga
    @OneToMany(mappedBy = "editor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Revista> revistas = new ArrayList<>();
}
