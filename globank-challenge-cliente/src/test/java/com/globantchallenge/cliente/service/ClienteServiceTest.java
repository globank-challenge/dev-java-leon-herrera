package com.globantchallenge.cliente.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClientException;

import com.globantchallenge.cliente.config.exceptions.ClienteException;
import com.globantchallenge.cliente.model.entity.Cliente;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {
	
	@InjectMocks
	static ClienteServiceImpl clienteServiceImpl;
	
	@Mock
	Cliente cliente;
	
	@BeforeAll
	static void setup() { clienteServiceImpl = new ClienteServiceImpl(); }

	
	@Test
	void test () {
		System.out.println("First test");
	}
	
	@Test
	void givenNullIdCliente_throwsClienteException() {
		Long idCliente = null;
		cliente.clienteId = idCliente;
		assertThrows(ClienteException.class, () -> clienteServiceImpl.crear(cliente));
	}
	
	

}