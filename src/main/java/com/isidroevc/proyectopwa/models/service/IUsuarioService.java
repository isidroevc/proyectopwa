package com.isidroevc.proyectopwa.models.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.isidroevc.proyectopwa.models.entity.Usuario;
@Service
public interface IUsuarioService {
	public List<Usuario> findAll();
	
	public void save(Usuario cliente);
	
	public Usuario findById(Long id);
	
	public void deleteById(Long id);
	
	public void asignarComoJefeDeCarrera(Long idCarrera);
}
