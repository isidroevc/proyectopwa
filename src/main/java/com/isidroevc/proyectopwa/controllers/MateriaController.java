package com.isidroevc.proyectopwa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.isidroevc.proyectopwa.models.entity.Carrera;
import com.isidroevc.proyectopwa.models.entity.Materia;
import com.isidroevc.proyectopwa.models.entity.Usuario;
import com.isidroevc.proyectopwa.models.service.ICarreraService;
import com.isidroevc.proyectopwa.models.service.IMateriaService;
import com.isidroevc.proyectopwa.models.service.IUsuarioService;

@Controller
@SessionAttributes("materia")
public class MateriaController {
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	ICarreraService carreraService;
	@Autowired
	IMateriaService materiaService;
	
	@GetMapping(value="/carreras/{idCarrera}/materias.jsp")
	@PreAuthorize("hasAuthority('JEFE')")
	public String listar(@PathVariable Long idCarrera, Model model, Authentication authentication) {
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Carrera carrera = carreraService.findById(idCarrera);
		if (!carrera.getIdJefe().equals(usuario.getId())) {
			return "redirect:/";
		}
		List<Materia> materias = materiaService.findByIdCarrera(idCarrera);
		model.addAttribute("carrera", carrera);
		model.addAttribute("titulo", carrera.getNombre().concat(" / Materias"));
		model.addAttribute("materias", materias);
		return "materia/listado";
	}
	
	@GetMapping(value="/carreras/{idCarrera}/materias/form.jsp")
	public String mostrarFormularioParaCreacion(@PathVariable Long idCarrera, Model model, Authentication authentication) {
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Carrera carrera = carreraService.findById(idCarrera);
		if (!carrera.getIdJefe().equals(usuario.getId())) {
			return "redirect:/";
		}
		Materia materia = new Materia();
		model.addAttribute("materia", materia);
		model.addAttribute("carrera", carrera);
		model.addAttribute("titulo", "Agregar materia");
		return "materia/form";
	}
	
	@GetMapping(value="/carreras/{idCarrera}/materias/{id}/form.jsp")
	public String mostrarFormularioParaEdicion(@PathVariable Long idCarrera, @PathVariable Long id, Model model, Authentication authentication) {
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Carrera carrera = carreraService.findById(idCarrera);
		if (!carrera.getIdJefe().equals(usuario.getId())) {
			return "redirect:/";
		}
		Materia materia = materiaService.findById(id);
		model.addAttribute("materia", materia);
		model.addAttribute("carrera", carrera);
		model.addAttribute("titulo", "Agregar materia");
		return "materia/form";
	}
	
	@PostMapping(value="/carreras/{idCarrera}/materias/form.jsp")
	public String guardar(@Valid Materia materia, Model model, BindingResult bindingResult, SessionStatus sessionStatus, @PathVariable Long idCarrera,Authentication authentication) {
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Carrera carrera = carreraService.findById(idCarrera);
		if (!carrera.getIdJefe().equals(usuario.getId())) {
			return "redirect:/";
		}
		if (bindingResult.hasErrors()) {
			model.addAttribute("titulo", materia.getId() != null ? "Editar materia" : "Agregar materia");
			return "materia/form";
		}
		materia.setIdCarrera(idCarrera);
		materiaService.save(materia);
		sessionStatus.setComplete();
		return "redirect:/carreras/" + idCarrera.toString() + "/materias.jsp";
	}
}
