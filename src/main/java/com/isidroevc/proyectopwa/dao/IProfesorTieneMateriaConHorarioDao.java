package com.isidroevc.proyectopwa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.isidroevc.proyectopwa.models.entity.ProfesorTieneMateriaConHorario;

public interface IProfesorTieneMateriaConHorarioDao extends CrudRepository<ProfesorTieneMateriaConHorario, Long> {
	public List<ProfesorTieneMateriaConHorario> findByIdCarrera(Long idCarrera);
	public List<ProfesorTieneMateriaConHorario> findByIdProfesor(Long idProfesor);
	
	public ProfesorTieneMateriaConHorario findByIdProfesorAndIdHorario(Long idProfesor, Long idHorario);
}
