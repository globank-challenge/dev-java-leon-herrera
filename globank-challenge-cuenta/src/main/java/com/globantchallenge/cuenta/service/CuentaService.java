package com.globantchallenge.cuenta.service;

import java.util.List;

import com.globantchallenge.cuenta.model.entity.Cuenta;

public interface CuentaService {

	public void crear(Cuenta cuenta);
	
	public void editar(Cuenta cuenta);
	
	public void actualizar(Cuenta cuenta);
	
	public void eliminar(Cuenta cuenta);
	
	public List<Cuenta> listar();
}
