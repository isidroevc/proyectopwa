package com.isidroevc.proyectopwa.models.service;



import java.util.List;

import com.isidroevc.proyectopwa.models.entity.Carrera;

public interface ICarreraService {
	public java.util.List<Carrera> findAll();
	
	public void save(Carrera cliente);
	
	public Carrera findById(Long id);
	
	public void deleteById(Long id);
	
	public List<Carrera> findByIdJefe(Long idJefe);
}
