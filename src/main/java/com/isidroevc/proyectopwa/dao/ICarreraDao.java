package com.isidroevc.proyectopwa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.isidroevc.proyectopwa.models.entity.Carrera;

public interface ICarreraDao extends CrudRepository<Carrera, Long>{
	public List<Carrera> findByIdJefe(Long idJefe);
}
