package com.isidroevc.proyectopwa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isidroevc.proyectopwa.dao.IHorarioDao;
import com.isidroevc.proyectopwa.models.entity.Horario;

@Service
public class HorarioService implements IHorarioService {
	
	@Autowired
	IHorarioDao horarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Horario> findAll() {
		return (List<Horario>)horarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Horario horario) {
		horarioDao.save(horario);
	}

	@Override
	@Transactional(readOnly = true)
	public Horario findById(Long id) {
		return horarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		horarioDao.deleteById(id);
	}

}
