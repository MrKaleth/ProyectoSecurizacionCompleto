package com.bonillaDario.proyectoSecurizar.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "campanas")
public class Campaña {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    private String descripcion;

    // Relación 1:N - El propietario (Director de Juego)
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Usuario propietario;

    // Relación N:M - Usuarios invitados a la campaña
    @ManyToMany
    @JoinTable(
        name = "campana_participantes",
        joinColumns = @JoinColumn(name = "campana_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> usuariosInvitados;

    // Relación 1:N - Una campaña tiene muchos personajes
    @OneToMany(mappedBy = "campaña", cascade = CascadeType.ALL)
    private List<Personaje> personajes;
}