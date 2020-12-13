package com.isidroevc.proyectopwa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.isidroevc.proyectopwa.models.entity.Carrera;
import com.isidroevc.proyectopwa.models.entity.ProfesorTieneMateriaConHorario;
import com.isidroevc.proyectopwa.models.entity.Usuario;
import com.isidroevc.proyectopwa.models.service.ICarreraService;
import com.isidroevc.proyectopwa.models.service.IProfesorTieneMateriaConHorarioService;
import com.isidroevc.proyectopwa.models.service.IUsuarioService;

@Controller
public class GrupoController {
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	ICarreraService carreraService;
	
	@Autowired
	IProfesorTieneMateriaConHorarioService grupoService;
	
	@GetMapping(value="/carreras/{idCarrera}/sabana.jsp")
	@PreAuthorize("hasAuthority('JEFE')")
	public String listar(@PathVariable Long idCarrera, Model model, Authentication authentication) {
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Carrera carrera = carreraService.findById(idCarrera);
		if (!carrera.getIdJefe().equals(usuario.getId())) {
			return "redirect:/";
		}
		List<ProfesorTieneMateriaConHorario> grupos = grupoService.findByIdCarrera(idCarrera);
		model.addAttribute("carrera", carrera);
		model.addAttribute("titulo", carrera.getNombre().concat(" / Grupos"));
		model.addAttribute("grupos", grupos);
		return "grupo/sabana";
	}
}
