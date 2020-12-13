package com.isidroevc.proyectopwa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isidroevc.proyectopwa.dao.ICarreraDao;
import com.isidroevc.proyectopwa.models.entity.Carrera;
import com.isidroevc.proyectopwa.models.entity.Usuario;
@Service
public class UsuarioService implements IUsuarioService {
	@Autowired
	IUsuarioDao usuarioDao;
	@Autowired
	ICarreraDao carreraDao;
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		usuarioDao.deleteById(id);
	}

	@Override
	@Transactional
	public void asignarComoJefeDeCarrera(Long idCarrera) {
		Carrera carrera = carreraDao.findById(idCarrera).get();
		
	}
	
	@Transactional
	public void saveProfesor(Usuario newProfesor) {
		Long idNewProfesor = newProfesor.getId();
		if (idNewProfesor != null && idNewProfesor > 0L) {
			
		}
	}

	@Override
	public List<Usuario> findByRole(String role) {
		return usuarioDao.findByRole(role);
	}
	
	@Override
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

}
