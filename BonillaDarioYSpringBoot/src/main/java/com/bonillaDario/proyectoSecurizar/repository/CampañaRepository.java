package com.bonillaDario.proyectoSecurizar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bonillaDario.proyectoSecurizar.models.Campaña;
import com.bonillaDario.proyectoSecurizar.models.Usuario;

@Repository
public interface CampañaRepository extends JpaRepository<Campaña, Long> {
    // Buscar campañas de un director específico
    List<Campaña> findByPropietario(Usuario propietario);
    
    // Cumplimos "Filtrar por uno de sus atributos" (ej. por nombre similar)
    List<Campaña> findByNombreContainingIgnoreCase(String nombre);
}