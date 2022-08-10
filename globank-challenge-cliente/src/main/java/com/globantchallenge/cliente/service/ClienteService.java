package com.globantchallenge.cliente.service;

import java.util.List;

import com.globantchallenge.cliente.model.entity.Cliente;


public interface ClienteService {
	
	public void crear(Cliente cliente);
	
	public void editar(Cliente cliente);
	
	public void actualizar(Cliente cliente);
		
	public void eliminar(Cliente cliente);
	
	public List<Cliente> listar();

}
