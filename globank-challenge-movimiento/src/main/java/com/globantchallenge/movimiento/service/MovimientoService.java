package com.globantchallenge.movimiento.service;

import java.util.List;

import org.springframework.web.client.RestClientException;

import com.globantchallenge.movimiento.config.exception.MovimientoException;
import com.globantchallenge.movimiento.model.entity.Movimiento;

public interface MovimientoService {

	public void crear(Movimiento movimiento) throws MovimientoException, RestClientException;
		
	public void actualizar(Movimiento movimiento) throws MovimientoException, RestClientException;
	
	public void eliminar(Movimiento movimiento) throws MovimientoException, RestClientException;
	
	public List<Movimiento> listar() throws MovimientoException, RestClientException;
}
