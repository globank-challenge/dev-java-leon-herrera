package com.globantchallenge.cuenta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globantchallenge.cuenta.model.entity.Cuenta;
import com.globantchallenge.cuenta.service.CuentaService;

@RestController
@RequestMapping(value = "/cuenta")
public class CuentaController {
	
	@Autowired
	private CuentaService cuentaService;
	
	@PostMapping(
			value = "/crear",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void crear(@RequestBody Cuenta cuenta) throws Exception{
		cuentaService.crear(cuenta);
	}
	
	public void editar(@RequestBody Cuenta cuenta) {
		cuentaService.editar(cuenta);
	}
	
	@PutMapping(
			value = "/actualizar",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void actualizar(@RequestBody Cuenta cuenta) throws Exception{
		cuentaService.actualizar(cuenta);
	}
	
	@DeleteMapping(
			value = "/eliminar",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void eliminar(@RequestBody Cuenta cuenta) throws Exception{
		cuentaService.eliminar(cuenta);
	}
	
	@GetMapping(
			value = "/listar",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Cuenta> listar() throws Exception{
		return (List<Cuenta>) cuentaService.listar();
	}

}
