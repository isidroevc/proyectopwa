package com.isidroevc.proyectopwa.models.service;


import java.util.List;

import com.isidroevc.proyectopwa.models.entity.Materia;

public interface IMateriaService {
	public List<Materia> findAll();
	
	public void save(Materia cliente);
	
	public Materia findById(Long id);
	
	public void deleteById(Long id);
	
	public List<Materia> findByIdCarrera(Long idCarrera);
}
