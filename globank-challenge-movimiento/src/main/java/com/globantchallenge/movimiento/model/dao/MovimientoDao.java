package com.globantchallenge.movimiento.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.globantchallenge.movimiento.model.entity.Movimiento;

public interface MovimientoDao extends CrudRepository<Movimiento, Long>{

}
