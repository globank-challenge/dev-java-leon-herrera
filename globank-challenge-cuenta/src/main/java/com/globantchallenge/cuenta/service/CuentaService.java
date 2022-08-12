package com.globantchallenge.cuenta.service;

import java.util.List;

import org.springframework.web.client.RestClientException;

import com.globantchallenge.cuenta.config.exception.CuentaException;
import com.globantchallenge.cuenta.model.entity.Cuenta;

public interface CuentaService {

	public void crear(Cuenta cuenta) throws CuentaException, RestClientException;
		
	public void actualizar(Cuenta cuenta) throws CuentaException, RestClientException;
	
	public void eliminar(Cuenta cuenta) throws CuentaException, RestClientException;
	
	public List<Cuenta> listar() throws CuentaException, RestClientException;
}
