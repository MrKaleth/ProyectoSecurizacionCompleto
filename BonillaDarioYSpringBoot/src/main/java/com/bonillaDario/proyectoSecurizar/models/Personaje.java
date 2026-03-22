package com.bonillaDario.proyectoSecurizar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "personajes")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer nivel;

    // Relación 1:N - El personaje pertenece a una campaña
    @ManyToOne
    @JoinColumn(name = "campana_id")
    private Campaña campaña;

    // El personaje pertenece a un usuario (jugador)
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario jugador;
}