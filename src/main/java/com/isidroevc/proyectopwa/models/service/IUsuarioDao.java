package com.isidroevc.proyectopwa.models.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.isidroevc.proyectopwa.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
	public List<Usuario> findByRole(String role);
}
