package com.isidroevc.proyectopwa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.isidroevc.proyectopwa.models.entity.Usuario;
import com.isidroevc.proyectopwa.models.service.IUsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	IUsuarioService usuarioService;
	@GetMapping(value="/usuarios/perfil.jsp")
	public String mostrarPerfil(Model model, Authentication authentication) {
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		model.addAttribute("titulo", "Perfil del usuario");
		model.addAttribute("profesor", usuario);
		return "usuario/profile";
	}
}
