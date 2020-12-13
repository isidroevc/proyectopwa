package com.isidroevc.proyectopwa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isidroevc.proyectopwa.dao.IAulaDao;
import com.isidroevc.proyectopwa.models.entity.Aula;

@Service
public class AulaService implements IAulaService{
	
	@Autowired
	IAulaDao aulaDao;
	@Override
	@Transactional(readOnly=true)
	public List<Aula> findAll() {
		return (List<Aula>)aulaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Aula aula) {
		aulaDao.save(aula);
	}

	@Override
	@Transactional(readOnly=true)
	public Aula findById(Long id) {
		return aulaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		aulaDao.deleteById(id);
	}

}
