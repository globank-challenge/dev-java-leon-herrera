package com.globantchallenge.cuenta.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.globantchallenge.cuenta.model.entity.Cuenta;

public interface CuentaDao extends CrudRepository<Cuenta, Long>{

}
