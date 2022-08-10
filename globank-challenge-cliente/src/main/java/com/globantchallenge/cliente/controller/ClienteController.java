package com.globantchallenge.cliente.controller;

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

import com.globantchallenge.cliente.model.entity.Cliente;
import com.globantchallenge.cliente.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping(
			value =  "/crear",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void crear(@RequestBody Cliente cliente) {
		clienteService.crear(cliente);
	}
	
	
	public void editar(@RequestBody Cliente cliente) {
		clienteService.editar(cliente);
	}
	
	@PutMapping(
			value = "/actualizar",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void actualizar(@RequestBody Cliente cliente) {
		clienteService.actualizar(cliente);
	}	

	@DeleteMapping(
			value = "/eliminar",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void eliminar(@RequestBody Cliente cliente) {
		clienteService.eliminar(cliente);
	}
	
	@GetMapping(
			value = "/listar",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Cliente> listar(){
		return clienteService.findAll();
	}
}
