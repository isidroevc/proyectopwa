package com.isidroevc.proyectopwa.models.service;

import org.springframework.stereotype.Service;

import com.isidroevc.proyectopwa.models.entity.Carrera;

public interface ICarreraService {
	public java.util.List<Carrera> findAll();
	
	public void save(Carrera cliente);
	
	public Carrera findById(Long id);
	
	public void deleteById(Long id);
}