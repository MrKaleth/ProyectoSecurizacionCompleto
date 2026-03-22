package com.bonillaDario.proyectoSecurizar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bonillaDario.proyectoSecurizar.models.Usuario;
import com.bonillaDario.proyectoSecurizar.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService service;

	@GetMapping("/lista")
	public String listar(Model model) {
		model.addAttribute("listaUsuarios", service.listarTodos());
		return "lista-usuarios";
	}

	@GetMapping("/nuevo")
	public String formulario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formulario-usuario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Usuario usuario) {
		service.guardar(usuario);
		return "redirect:/usuarios/lista";
	}
}