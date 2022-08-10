package com.globantchallenge.cliente.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globantchallenge.cliente.model.dao.ClienteDao;
import com.globantchallenge.cliente.model.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public void crear(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public void editar(Cliente cliente) {
		
	}

	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public void actualizar(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(rollbackFor = {SQLException.class})	
	public void eliminar(Cliente cliente) {
		clienteDao.delete(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		List<Cliente> clienteList = (List<Cliente>) clienteDao.findAll();
		return clienteList;
	}

}
