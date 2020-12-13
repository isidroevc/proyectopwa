package com.isidroevc.proyectopwa.models.service;

import java.util.List;

import com.isidroevc.proyectopwa.models.entity.Horario;

public interface IHorarioService {
	public List<Horario> findAll();
	
	public void save(Horario horario);
	
	public Horario findById(Long id);
	
	public void deleteById(Long id);
	
}
