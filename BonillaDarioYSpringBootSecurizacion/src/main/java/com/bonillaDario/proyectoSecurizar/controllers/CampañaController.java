package com.bonillaDario.proyectoSecurizar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bonillaDario.proyectoSecurizar.models.Campaña;
import com.bonillaDario.proyectoSecurizar.service.CampañaService;

@Controller
@RequestMapping("/campanas")
public class CampañaController {

	@Autowired
	private CampañaService campañaService;

	// 1. Listado que redirige a HTML (Thymeleaf)
	@GetMapping("/lista")
	public String listarCampanas(Model model) {
		model.addAttribute("listaCampanas", campañaService.listarTodas());
		return "lista-campanas"; // Esto buscará lista-campanas.html en templates
	}

	// 2. Servicio que devuelve JSON (Requisito: Al menos uno JSON)
	@GetMapping("/api/json")
	@ResponseBody
	public List<Campaña> listarTodasJson() {
		return campañaService.listarTodas();
	}

	// 3. Formulario para alta (GET)
	@GetMapping("/nuevo")
	public String formularioNuevaCampaña(Model model) {
		model.addAttribute("campana", new Campaña());
		return "formulario-campana";
	}

	// 4. Guardar (POST) con redirección
	@PostMapping("/guardar")
	public String guardarCampaña(@ModelAttribute Campaña campaña) {
		campañaService.guardar(campaña);
		return "redirect:/campanas/lista";
	}
}