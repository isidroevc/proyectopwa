package com.isidroevc.proyectopwa.models.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.isidroevc.proyectopwa.models.entity.Materia;

public interface IMateriaDao extends CrudRepository<Materia, Long>{
	public List<Materia> findByIdCarrera(Long idCarrera);
}
