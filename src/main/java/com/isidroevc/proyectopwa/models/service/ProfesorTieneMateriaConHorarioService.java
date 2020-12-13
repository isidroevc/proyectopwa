package com.isidroevc.proyectopwa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isidroevc.proyectopwa.dao.IProfesorTieneMateriaConHorarioDao;
import com.isidroevc.proyectopwa.models.entity.ProfesorTieneMateriaConHorario;

@Service
public class ProfesorTieneMateriaConHorarioService implements IProfesorTieneMateriaConHorarioService {
	
	@Autowired
	private IProfesorTieneMateriaConHorarioDao profesorTieneMateriaConHorarioDao;
	@Override
	@Transactional
	public void save(ProfesorTieneMateriaConHorario profesorTieneMateriaConHorario) {
		profesorTieneMateriaConHorarioDao.save(profesorTieneMateriaConHorario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProfesorTieneMateriaConHorario> findByIdCarrera(Long idCarrera) {
		return profesorTieneMateriaConHorarioDao.findByIdCarrera(idCarrera);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProfesorTieneMateriaConHorario> findByIdProfesor(Long idProfesor) {
		return profesorTieneMateriaConHorarioDao.findByIdProfesor(idProfesor);
	}
	
	@Override
	@Transactional(readOnly=true)
	public ProfesorTieneMateriaConHorario findByIdProfesorAndIdHorario(Long idProfesor, Long idHorario) {
		return profesorTieneMateriaConHorarioDao.findByIdProfesorAndIdHorario(idProfesor, idHorario);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		profesorTieneMateriaConHorarioDao.deleteById(id);
	}

}
