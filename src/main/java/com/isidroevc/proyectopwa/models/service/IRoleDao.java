package com.isidroevc.proyectopwa.models.service;

import org.springframework.data.repository.CrudRepository;

import com.isidroevc.proyectopwa.models.entity.Role;

public interface IRoleDao extends CrudRepository<Role, Long>{
	public void deleteByUserIdAndIdCarrera(Long userId, Long IdCarrera);
}
