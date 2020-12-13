package com.isidroevc.proyectopwa.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.isidroevc.proyectopwa.models.entity.Aula;
import com.isidroevc.proyectopwa.models.entity.Carrera;
import com.isidroevc.proyectopwa.models.entity.Horario;
import com.isidroevc.proyectopwa.models.entity.Materia;
import com.isidroevc.proyectopwa.models.entity.ProfesorTieneMateriaConHorario;
import com.isidroevc.proyectopwa.models.entity.Usuario;
import com.isidroevc.proyectopwa.models.service.IAulaService;
import com.isidroevc.proyectopwa.models.service.ICarreraService;
import com.isidroevc.proyectopwa.models.service.IHorarioService;
import com.isidroevc.proyectopwa.models.service.IMateriaService;
import com.isidroevc.proyectopwa.models.service.IProfesorTieneMateriaConHorarioService;
import com.isidroevc.proyectopwa.models.service.IUsuarioService;

@Controller
@SessionAttributes("grupo")
public class GrupoController {
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	ICarreraService carreraService;
	
	@Autowired
	IHorarioService horarioService;
	
	@Autowired
	IAulaService aulaService;
	
	@Autowired
	IProfesorTieneMateriaConHorarioService grupoService;
	
	@Autowired
	IMateriaService materiaService;
	@GetMapping(value="/carreras/{idCarrera}/sabana.jsp")
	@PreAuthorize("hasAuthority('JEFE')")
	public String listar(@PathVariable Long idCarrera, @RequestParam Optional<Long> idProfesor, Model model, Authentication authentication) {
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Carrera carrera = carreraService.findById(idCarrera);
		if (!carrera.getIdJefe().equals(usuario.getId())) {
			return "redirect:/";
		}
		List<ProfesorTieneMateriaConHorario> grupos;
		
		if (idProfesor.isPresent() && idProfesor.get() > 0) {
			Usuario profesor = usuarioService.findById(idProfesor.get());
			grupos = grupoService.findByIdProfesor(idProfesor.get());
			model.addAttribute("idProfesorActual", idProfesor.get());
			String nombreCompleto = profesor.getNombre() + " " + profesor.getPrimerApellido() + " " + profesor.getSegundoApellido();
			model.addAttribute("titulo", nombreCompleto.concat(" / Grupos"));
		} else {
			grupos = grupoService.findByIdCarrera(idCarrera);
			model.addAttribute("idProfesorActual", 0);
			model.addAttribute("titulo", carrera.getNombre().concat(" / Grupos"));
		}
		List<Usuario> profesores = usuarioService.findByRole("PROFESOR");
		model.addAttribute("profesores", profesores);
		
		model.addAttribute("carrera", carrera);
		
		model.addAttribute("grupos", grupos);
		return "grupo/sabana";
	}
	
	@GetMapping(value="/carreras/{idCarrera}/grupos/form.jsp")
	public String mostrarFormularioParaCreacion(@PathVariable Long idCarrera, Model model, Authentication authentication) {
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Carrera carrera = carreraService.findById(idCarrera);
		if (!carrera.getIdJefe().equals(usuario.getId())) {
			return "redirect:/";
		}
		ProfesorTieneMateriaConHorario grupo = new ProfesorTieneMateriaConHorario();
		List<Usuario> profesores = usuarioService.findByRole("PROFESOR");
		List<Materia> materias = materiaService.findByIdCarrera(idCarrera);
		List<Horario> horarios = horarioService.findAll();
		List<Aula> aulas = aulaService.findAll();
		model.addAttribute("grupo", grupo);
		model.addAttribute("profesores", profesores);
		model.addAttribute("materias", materias);
		model.addAttribute("horarios", horarios);
		model.addAttribute("aulas", aulas);
		model.addAttribute("carrera", carrera);
		model.addAttribute("titulo", "Agregar grupo");
		return "grupo/form";
	}
	
	
	@PostMapping(value="/carreras/{idCarrera}/grupos/form.jsp")
	public String guardar(@Valid ProfesorTieneMateriaConHorario grupo, Model model, BindingResult bindingResult, SessionStatus sessionStatus, @PathVariable Long idCarrera,Authentication authentication) {
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Carrera carrera = carreraService.findById(idCarrera);
		if (!carrera.getIdJefe().equals(usuario.getId())) {
			return "redirect:/";
		}
		ProfesorTieneMateriaConHorario horarioEmpalmado = grupoService.findByIdProfesorAndIdHorario(grupo.getIdProfesor(), grupo.getIdHorario());
		if (bindingResult.hasErrors() || horarioEmpalmado != null) {
			if (horarioEmpalmado != null) {
				model.addAttribute("empalme", true);
			}
			List<Usuario> profesores = usuarioService.findByRole("PROFESOR");
			List<Materia> materias = materiaService.findByIdCarrera(idCarrera);
			List<Horario> horarios = horarioService.findAll();
			List<Aula> aulas = aulaService.findAll();
			model.addAttribute("grupo", grupo);
			model.addAttribute("profesores", profesores);
			model.addAttribute("materias", materias);
			model.addAttribute("horarios", horarios);
			model.addAttribute("aulas", aulas);
			model.addAttribute("carrera", carrera);
			model.addAttribute("titulo", grupo.getId()  != null ?"Editar materia" : "Agregar materia");
			return "grupo/form";
		}
		grupo.setIdCarrera(idCarrera);
		grupoService.save(grupo);
		sessionStatus.setComplete();
		return "redirect:/carreras/" + idCarrera.toString() + "/sabana.jsp";
	}
	
	@GetMapping(value="/carreras/{idCarrera}/grupos/{id}/eliminar.jsp")
	
	public String eliminar(@PathVariable Long idCarrera, @PathVariable Long id, Model model) {
		grupoService.deleteById(id);
		return "redirect:/carreras/" + idCarrera.toString() + "/sabana.jsp";
	}
}
