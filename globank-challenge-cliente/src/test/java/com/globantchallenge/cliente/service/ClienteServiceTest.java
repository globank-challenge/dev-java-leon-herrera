package com.globantchallenge.cliente.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClientException;

import com.globantchallenge.cliente.config.exceptions.ClienteException;
import com.globantchallenge.cliente.model.dao.ClienteDao;
import com.globantchallenge.cliente.model.entity.Cliente;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

/**
 * Pruebas para el servicio cliente
 * @author leon.herrera
 *
 */
@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {
	
	@InjectMocks
	static ClienteService clienteService;
	
	@Mock
	ClienteDao clienteDao;
	
	@Mock
	Cliente cliente;
	
	@BeforeAll
	static void setup() { clienteService = new ClienteServiceImpl(); }

	@Test
	void givenNullPasswordCrear_throwsClienteException() {
		cliente.contrasenia = null;
		cliente.estado = false;
		assertThrows(ClienteException.class, () -> clienteService.crear(cliente));
	}
	
	@Test
	void givenNullEstadoCrear_throwsClienteException() {
		cliente.contrasenia = "JoseRepelín123";
		cliente.estado = null;
		assertThrows(ClienteException.class, () -> clienteService.crear(cliente));
	}

	@Test
	void givenNegativeIdClienteAtActualizar_throwsClienteException() {
		cliente.clienteId = -4L;
		assertThrows(ClienteException.class, () -> clienteService.actualizar(cliente));
	}

	@Test
	void givenNullIdClientAtActualizar_throwsClienteException() {
		cliente.clienteId = 0L;
		assertThrows(ClienteException.class, () -> clienteService.actualizar(cliente));
	}

	@Test
	void givenNullIdClientAtEliminar_throwsClienteException() {
		cliente.clienteId = 0L;
		assertThrows(ClienteException.class, () -> clienteService.eliminar(cliente));
	}	
	
	@Test
	void givenNegativeIdClienteAtEliminar_throwsClienteException() {
		cliente.clienteId = -4L;
		assertThrows(ClienteException.class, () -> clienteService.eliminar(cliente));
	}

	@Test
	void givenNoneRegisterFromDBAtListar_throwsClienteException() throws RestClientException, Exception {
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(new Cliente());
		
		when(clienteDao.findAll()).thenReturn(clientes);
		
		assertThrows(ClienteException.class, () -> clienteService.listar());
	}
	
	
	
}