package com.isidroevc.proyectopwa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isidroevc.proyectopwa.dao.ICarreraDao;
import com.isidroevc.proyectopwa.models.entity.Carrera;
import com.isidroevc.proyectopwa.models.entity.Role;
import com.isidroevc.proyectopwa.models.entity.Usuario;
@Service
public class CarreraService implements ICarreraService{
	@Autowired
	private ICarreraDao carreraDao;
	
	@Autowired
	private IRoleDao roleDao;
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Carrera> findAll() {
		return (List<Carrera>)carreraDao.findAll();
	}

	@Override
	@Transactional
	public void save(Carrera carreraNew) {
		Long idJefeNew = carreraNew.getIdJefe();
		if (carreraNew.getId() != null && carreraNew.getId() > 0L && idJefeNew != null && idJefeNew > 0L) {
			Carrera carreraOld = carreraDao.findById(carreraNew.getId()).get();
			Long idJefeOld = carreraOld != null ? carreraOld.getIdJefe() : null;
			if (idJefeOld != null && idJefeOld > 0) {
				roleDao.deleteByIdCarrera(carreraNew.getId());
				asignarCarrera(idJefeNew, carreraNew.getId());
			}
			carreraDao.save(carreraNew);
		} else {
			carreraDao.save(carreraNew);
			asignarCarrera(idJefeNew, carreraNew.getId());
		}
	}
	private void asignarCarrera(Long idJefeNew, Long idCarreraNew) {
		Usuario jefeNew = usuarioDao.findById(idJefeNew).get();
		Role newRole = new Role();
		newRole.setAuthority("JEFE");
		newRole.setIdCarrera(idCarreraNew);
		newRole.setUserId(jefeNew.getId());
		newRole.setUsername(jefeNew.getUsername());
		roleDao.save(newRole);
	}

	@Override
	public Carrera findById(Long id) {
		return carreraDao.findById(id).get();
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		carreraDao.deleteById(id);
	}

}
