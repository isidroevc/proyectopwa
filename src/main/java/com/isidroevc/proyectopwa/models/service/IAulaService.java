package com.isidroevc.proyectopwa.models.service;

import java.util.List;

import com.isidroevc.proyectopwa.models.entity.Aula;

public interface IAulaService {
	public List<Aula> findAll();
	
	public void save(Aula aula);
	
	public Aula findById(Long id);
	
	public void deleteById(Long id);
	
}
