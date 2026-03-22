package com.bonillaDario.proyectoSecurizar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonillaDario.proyectoSecurizar.models.Personaje;
import com.bonillaDario.proyectoSecurizar.repository.PersonajeRepository;

@Service
public class PersonajeService {
    @Autowired private PersonajeRepository repo;

    public void guardar(Personaje p) { repo.save(p); }
    public List<Personaje> listar() { return repo.findAll(); }
    
    // Requisito: Modificar la propiedad de al menos uno de tus atributos
    public Personaje subirNivel(Long id) {
        Personaje p = repo.findById(id).orElseThrow();
        p.setNivel(p.getNivel() + 1);
        return repo.save(p);
    }
}