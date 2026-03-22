package com.bonillaDario.proyectoSecurizar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bonillaDario.proyectoSecurizar.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
		if ("admin".equals(username) && "admin".equals(password)) {
			String token = jwtUtil.generateToken(username);
			return ResponseEntity.ok(token); // Devuelve 200 OK con el Token
		}
		// Devuelve 401 si las credenciales son malas (Requisito del PDF)
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
	}
}