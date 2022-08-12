package com.globantchallenge.cliente.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestClientException;

import com.globantchallenge.cliente.config.exceptions.ClienteException;
import com.globantchallenge.cliente.model.dao.ClienteDao;
import com.globantchallenge.cliente.model.entity.Cliente;
import com.google.common.base.Strings;

@Service
public class ClienteServiceImpl implements ClienteService{

	private static final String CLIENTE_INFO_SERVICIO_CREAR_OBJETO_CLIENTE_NULO_O_VACIO = "La información del cliente debe estar completa para crear el registro";
	private static final String CLIENTE_INFO_SERVICIO_ACTUALIZAR_ID_CLIENTE_VACIO = "Debe ingresar id del registro cliente a actualizar";
	private static final String CLIENTE_INFO_SERVICIO_ACTUALIZAR_ID_CLIENTE_DEBE_SER_MAYOR_A_CERO = "El id del cliente a actualizar debe ser mayor a 0";
	private static final String CLIENTE_INFO_SERVICIO_ELIMINAR_ID_CLIENTE_VACIO = "El id del registro Cliente a eliminar no puede estar vacio";
	private static final String CLIENTE_INFO_SERVICIO_ELIMINAR_ID_CLIENTE_DEBE_SER_MAYOR_A_CERO = "El id del cliente a eliminar debe ser mayor a 0";
	private static final String CLIENTE_INFO_SERVICIO_CONSULTAR_TODO_NO_HAY_EXISTENCIA_DE_REGISTROS = "No hay existencia de clientes en la base de datos";
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public void crear(Cliente cliente) throws ClienteException, RestClientException {
		if(ObjectUtils.isEmpty(cliente) || Strings.isNullOrEmpty(cliente.contrasenia) || cliente.estado.equals(null)) throw new ClienteException(CLIENTE_INFO_SERVICIO_CREAR_OBJETO_CLIENTE_NULO_O_VACIO);
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public void actualizar(Cliente cliente) throws ClienteException, RestClientException {
		if(clienteIdIgualACero(cliente)) throw new ClienteException(CLIENTE_INFO_SERVICIO_ACTUALIZAR_ID_CLIENTE_VACIO);
		if(clienteIdMenorACero(cliente)) throw new ClienteException(CLIENTE_INFO_SERVICIO_ACTUALIZAR_ID_CLIENTE_DEBE_SER_MAYOR_A_CERO);		
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(rollbackFor = {SQLException.class})	
	public void eliminar(Cliente cliente) throws ClienteException, RestClientException{
		if(clienteIdIgualACero(cliente)) throw new ClienteException(CLIENTE_INFO_SERVICIO_ELIMINAR_ID_CLIENTE_VACIO);		
		if(clienteIdMenorACero(cliente)) throw new ClienteException(CLIENTE_INFO_SERVICIO_ELIMINAR_ID_CLIENTE_DEBE_SER_MAYOR_A_CERO);		
		clienteDao.delete(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> listar() throws ClienteException, RestClientException{
		List<Cliente> clienteList = (List<Cliente>) clienteDao.findAll();
		if(clienteList.isEmpty()) throw new ClienteException(CLIENTE_INFO_SERVICIO_CONSULTAR_TODO_NO_HAY_EXISTENCIA_DE_REGISTROS);
		return clienteList;
	}
	
	private Boolean clienteIdIgualACero (Cliente cliente) {
		return cliente.clienteId.equals(0);
	}

	private Boolean clienteIdMenorACero (Cliente cliente) {
		return cliente.clienteId < 0;
	}
}
