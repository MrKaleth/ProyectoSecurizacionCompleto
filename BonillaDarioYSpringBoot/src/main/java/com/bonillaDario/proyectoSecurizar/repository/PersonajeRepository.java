package com.bonillaDario.proyectoSecurizar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bonillaDario.proyectoSecurizar.models.Campaña;
import com.bonillaDario.proyectoSecurizar.models.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
    // Listar todos los personajes de una campaña concreta
    List<Personaje> findByCampaña(Campaña campaña);
}