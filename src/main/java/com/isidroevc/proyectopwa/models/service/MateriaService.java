package com.isidroevc.proyectopwa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isidroevc.proyectopwa.models.entity.Materia;
@Service
public class MateriaService implements IMateriaService {
	
	@Autowired
	private IMateriaDao materiaDao;
	@Override
	@Transactional(readOnly = true)
	public List<Materia> findAll() {
		return (List<Materia>)materiaDao.findAll();
	}

	@Override
	@Transactional()
	public void save(Materia materia) {
		materiaDao.save(materia);
	}

	@Override
	@Transactional(readOnly = true)
	public Materia findById(Long id) {
		return materiaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public void deleteById(Long id) {
		materiaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Materia> findByIdCarrera(Long idCarrera) {
		return materiaDao.findByIdCarrera(idCarrera);
	}

}
