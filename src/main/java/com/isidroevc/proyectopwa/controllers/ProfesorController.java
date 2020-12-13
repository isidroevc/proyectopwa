package com.isidroevc.proyectopwa.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.isidroevc.proyectopwa.models.entity.Carrera;
import com.isidroevc.proyectopwa.models.entity.Usuario;
import com.isidroevc.proyectopwa.models.service.ICarreraService;
import com.isidroevc.proyectopwa.models.service.IUsuarioService;

@Controller
@RequestMapping(value="/profesores")
@SessionAttributes("profesor")
public class ProfesorController {
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	ICarreraService carreraService;
	@GetMapping(value="/listado.jsp")
	public String listado(Model model) {
		List<Usuario> profesores = usuarioService.findAll();
		model.addAttribute("profesores", profesores);
		return "profesor/listado";
	}
	
	
	@GetMapping("/form.jsp")
	public String mostrarFormularioCreacion(Model model) {
		Usuario profesor = new Usuario();
		List<Carrera> carreras = carreraService.findAll();
		model.addAttribute("carreras", carreras);
		model.addAttribute("titulo", "Agregar profesor");
		model.addAttribute("profesor", profesor);
		return "profesor/form";
	}
	
	@PostMapping("/form.jsp")
	public String crear(@Valid Usuario profesor, BindingResult bindingResult, Map<String, Object> model, SessionStatus sessionStatus) {
		List<Carrera> carreras = carreraService.findAll();
		model.put("carreras", carreras);
		if (bindingResult.hasErrors()) {
			model.put("titulo", "Editar profesor");
			return "profesor/form";
		} else {
			usuarioService.save(profesor);
			sessionStatus.setComplete();
			return "redirect:/profesores/listado.jsp";
		}
	}
	
	@GetMapping(value="/form/{id}")
	public String editar(@PathVariable Long id, Map<String, Object> model, HttpSession session) {
		Usuario profesor = null;
		List<Carrera> carreras= carreraService.findAll();
		if (id > 0) {
			profesor = usuarioService.findById(id);
		} else {
			return "redirect:/carreras/listado";
			
		}
		model.put("profesor", profesor);
		model.put("carreras", carreras);
		model.put("titulo", "Editar profesor");
		return "profesor/form";
	}
}
