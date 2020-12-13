package com.isidroevc.proyectopwa.dao;


import org.springframework.data.repository.CrudRepository;

import com.isidroevc.proyectopwa.models.entity.Horario;

public interface IHorarioDao extends CrudRepository<Horario, Long>{
}