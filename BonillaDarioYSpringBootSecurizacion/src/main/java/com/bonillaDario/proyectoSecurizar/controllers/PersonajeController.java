package com.bonillaDario.proyectoSecurizar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bonillaDario.proyectoSecurizar.models.Personaje;
import com.bonillaDario.proyectoSecurizar.service.PersonajeService;

@Controller
@RequestMapping("/personajes")
public class PersonajeController {
    @Autowired private PersonajeService service;

    // Requisito: Devolver una CADENA
    @GetMapping("/saludo")
    @ResponseBody
    public String saludar() {
        return "Bienvenido a la gestión de héroes de EpicVault";
    }

    // Requisito: Modificar propiedad y devolver JSON
    @PostMapping("/subir-nivel/{id}")
    @ResponseBody
    public ResponseEntity<Personaje> subirNivel(@PathVariable Long id) {
        return ResponseEntity.ok(service.subirNivel(id));
    }
}