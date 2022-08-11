package com.globantchallenge.movimiento.service;

import java.util.List;

import com.globantchallenge.movimiento.model.entity.Movimiento;

public interface MovimientoService {

	public void crear(Movimiento movimiento);
		
	public void actualizar(Movimiento movimiento);
	
	public void eliminar(Movimiento movimiento);
	
	public List<Movimiento> listar();
}
