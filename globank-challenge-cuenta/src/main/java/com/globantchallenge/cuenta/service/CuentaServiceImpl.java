package com.globantchallenge.cuenta.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globantchallenge.cuenta.model.dao.CuentaDao;
import com.globantchallenge.cuenta.model.entity.Cuenta;

@Service
public class CuentaServiceImpl implements CuentaService{

	@Autowired
	private CuentaDao cuentaDao;
	
	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public void crear(Cuenta cuenta) {
		cuentaDao.save(cuenta);
	}

	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public void editar(Cuenta cuenta) {
		
	}

	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public void actualizar(Cuenta cuenta) {
		cuentaDao.save(cuenta);
	}

	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public void eliminar(Cuenta cuenta) {
		cuentaDao.delete(cuenta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> listar() {
		List<Cuenta> cuentaList = (List<Cuenta>) cuentaDao.findAll();
		return cuentaList;
	}

}
