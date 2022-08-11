package com.globantchallenge.movimiento.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globantchallenge.movimiento.model.dao.MovimientoDao;
import com.globantchallenge.movimiento.model.entity.Movimiento;

@Service
public class MovimientoServiceImpl implements MovimientoService{

	@Autowired
	private MovimientoDao movimientoDao;
	
	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public void crear(Movimiento movimiento) {
		setFechaActual(movimiento);
		movimientoDao.save(movimiento);
	}

	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public void actualizar(Movimiento movimiento) {
		setFechaActual(movimiento);
		movimientoDao.save(movimiento);
	}


	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public void eliminar(Movimiento movimiento) {
		movimientoDao.delete(movimiento);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movimiento> listar() {
		return (List<Movimiento>) movimientoDao.findAll();
	}

	private Movimiento setFechaActual(Movimiento movimiento) {
		movimiento.fecha = LocalDate.now();
		return movimiento;
	}
}
