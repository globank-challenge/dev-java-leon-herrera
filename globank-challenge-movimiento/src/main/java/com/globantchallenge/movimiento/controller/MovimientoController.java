package com.globantchallenge.movimiento.controller;

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

import com.globantchallenge.movimiento.model.entity.Movimiento;
import com.globantchallenge.movimiento.service.MovimientoService;

@RestController
@RequestMapping(value = "/movimiento")
public class MovimientoController {

	@Autowired
	private MovimientoService movimientoService;
	
	@PostMapping(
			value = "/crear",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void crear(@RequestBody Movimiento movimiento) throws Exception{
		movimientoService.crear(movimiento);
	}
		
	@PutMapping(
			value = "/actualizar",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void actualizar(@RequestBody Movimiento movimiento) throws Exception{
		movimientoService.actualizar(movimiento);
	}
	
	@DeleteMapping(
			value = "/eliminar",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void eliminar(@RequestBody Movimiento movimiento) throws Exception{
		movimientoService.eliminar(movimiento);
	}
	
	@GetMapping(
			value = "/listar",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Movimiento> listar() throws Exception{
		return (List<Movimiento>) movimientoService.listar();
	}
	
}
