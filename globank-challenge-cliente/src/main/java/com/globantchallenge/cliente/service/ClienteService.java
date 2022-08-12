package com.globantchallenge.cliente.service;

import java.util.List;

import org.springframework.web.client.RestClientException;

import com.globantchallenge.cliente.model.entity.Cliente;


public interface ClienteService {
	
	public void crear(Cliente cliente) throws Exception, RestClientException;
		
	public void actualizar(Cliente cliente) throws Exception, RestClientException;
		
	public void eliminar(Cliente cliente) throws Exception, RestClientException;
	
	public List<Cliente> listar() throws Exception, RestClientException;

}
