package com.isidroevc.proyectopwa.models.service;

import java.util.List;

import com.isidroevc.proyectopwa.models.entity.ProfesorTieneMateriaConHorario;

public interface IProfesorTieneMateriaConHorarioService {
	public void save(ProfesorTieneMateriaConHorario profesorTieneMateriaConHorario);
	public List<ProfesorTieneMateriaConHorario> findByIdCarrera(Long idCarrera);
	public List<ProfesorTieneMateriaConHorario> findByIdProfesor(Long idProfesor);
}
