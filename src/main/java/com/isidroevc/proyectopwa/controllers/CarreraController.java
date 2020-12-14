package com.isidroevc.proyectopwa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.isidroevc.proyectopwa.models.entity.Carrera;
import com.isidroevc.proyectopwa.models.service.ICarreraService;
import com.isidroevc.proyectopwa.models.service.IUsuarioService;
import com.isidroevc.proyectopwa.models.entity.Usuario;

@Controller
@SessionAttributes("carrera")
@RequestMapping(value="/carreras")
public class CarreraController {
	@Autowired
	ICarreraService carreraService;
	
	@Autowired
	IUsuarioService usuarioService;
	private Logger logger = LoggerFactory.getLogger(CarreraController.class);
	
	@GetMapping(value="/listado.jsp")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de carreras");
		model.addAttribute("carreras", carreraService.findAll());
		return "carrera/listado";
	}
	
	@GetMapping("/form.jsp")
	public String mostrarFormularioCreacion(Model model) {
		Carrera carrera = new Carrera();
		List<Usuario> usuarios = usuarioService.findByRole("JEFE");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("titulo", "Agregar carrera");
		model.addAttribute("carrera", carrera);
		return "carrera/form";
	}
	
	@PostMapping("/form")
	public String crear(@Valid Carrera carrera, BindingResult bindingResult, Model model, SessionStatus sessionStatus) {
		List<Usuario> usuarios = usuarioService.findByRole("JEFE");
		model.addAttribute("usuarios", usuarios);
		if (bindingResult.hasErrors()) {
			model.addAttribute("titulo", "Agregar carrera");
			return "carrera/form";
		} else {
			carreraService.save(carrera);
			sessionStatus.setComplete();
			return "redirect:/carreras/listado.jsp";
		}
	}
	
	@GetMapping(value="/form/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Carrera carrera = null;
		List<Usuario> usuarios = usuarioService.findByRole("Jefe");
		if (id > 0) {
			carrera = carreraService.findById(id);
		} else {
			return "redirect:/carreras/listado";
			
		}
		logger.info(carrera.getNombre().concat(carrera.getId().toString()));
		model.addAttribute("carrera", carrera);
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("titulo", "Editar carrera");
		return "carrera/form";
	}
	
	
	//Rutas para el jefe de carrera.
	@GetMapping(value="/menu.jsp")
	@PreAuthorize("hasAuthority('JEFE')")
	public String menu(Model model, Authentication authentication) {
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		List<Carrera> carreras = carreraService.findByIdJefe(usuario.getId());
		model.addAttribute("carreras", carreras);
		model.addAttribute("titulo", "Carreras que administras.");
		return "carrera/menu";
	}
	
	@GetMapping(value="/{idCarrera}/administrar.jsp")
	@PreAuthorize("hasAuthority('JEFE')")
	public String administrar(@PathVariable Long idCarrera, Model model, Authentication authentication) {
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Carrera carrera = carreraService.findById(idCarrera);
		if (!usuario.getId().equals(carrera.getIdJefe())) {
			return "redirect:/carreras/menu.jsp";
		}
		model.addAttribute("carrera", carrera);
		model.addAttribute("titulo", carrera.getNombre());
		return "carrera/administrar";
	}
}
