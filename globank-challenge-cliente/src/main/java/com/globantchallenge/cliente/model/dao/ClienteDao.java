package com.globantchallenge.cliente.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.globantchallenge.cliente.model.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{

}
