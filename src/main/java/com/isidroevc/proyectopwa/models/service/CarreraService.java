package com.isidroevc.proyectopwa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isidroevc.proyectopwa.dao.ICarreraDao;
import com.isidroevc.proyectopwa.models.entity.Carrera;
@Service
public class CarreraService implements ICarreraService{
	@Autowired
	private ICarreraDao carreraDao;
	
	@Autowired
	private IRoleDao roleDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Carrera> findAll() {
		return (List<Carrera>)carreraDao.findAll();
	}

	@Override
	@Transactional
	public void save(Carrera carrera) {
		Carrera carreraActual = carreraDao.findById(carrera.getId()).get();
		if (!carreraActual.getIdJefe().equals(carrera.getIdJefe())) {
			roleDao.deleteByUserIdAndIdCarrera(carreraActual.getIdJefe(), carrera.getId());
		}
		carreraDao.save(carrera);
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
