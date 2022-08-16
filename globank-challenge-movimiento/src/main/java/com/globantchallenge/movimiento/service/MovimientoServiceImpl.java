package com.globantchallenge.movimiento.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestClientException;

import com.globantchallenge.movimiento.config.exception.MovimientoException;
import com.globantchallenge.movimiento.model.dao.MovimientoDao;
import com.globantchallenge.movimiento.model.entity.Movimiento;
import com.google.common.base.Strings;

@Service
public class MovimientoServiceImpl implements MovimientoService {

	private static final String MOVIMIENTO_INFO_SERVICIO_CREAR_OBJETO_MOVIMIENTO_NULO_O_VACIO = "La información del movimiento debe estar completa para crear el registro";
	private static final String MOVIMIENTO_INFO_SERVICIO_CREAR_OBJETO_SALDO_DEBE_SER_POSITIVO = "Debe tener un saldo inicial a favor para crear el movimiento";
	private static final String MOVIMIENTO_INFO_SERVICIO_CREAR_OBJETO_VALOR_DEBE_SER_POSITIVO = "Debe tener un valor positivo para la transaciión";
	private static final String MOVIMIENTO_INFO_SERVICIO_ACTUALIZAR_ID_CUENTA_VACIO = "Debe ingresar id del registro Movimiento a actualizar";
	private static final String MOVIMIENTO_INFO_SERVICIO_ACTUALIZAR_ID_CUENTA_DEBE_SER_MAYOR_A_CERO = "El id de lmovimiento a actualizar debe ser mayor a 0";
	private static final String MOVIMIENTO_INFO_SERVICIO_ELIMINAR_ID_CUENTA_VACIO = "El id del registro Movimiento a eliminar no puede estar vacio";
	private static final String MOVIMIENTO_INFO_SERVICIO_ELIMINAR_ID_CUENTA_DEBE_SER_MAYOR_A_CERO = "El id del movimiento a eliminar debe ser mayor a 0";
	private static final String MOVIMIENTO_INFO_SERVICIO_CONSULTAR_TODO_CUENTA_NO_HAY_EXISTENCIA_DE_REGISTROS = "No hay existencia de cuentas en la base de datos";

	@Autowired
	private MovimientoDao movimientoDao;

	@Override
	@Transactional(rollbackFor = { SQLException.class })
	public void crear(Movimiento movimiento) throws MovimientoException, RestClientException {
		if (ObjectUtils.isEmpty(movimiento) || Strings.isNullOrEmpty(movimiento.tipoMovimiento)
				|| movimiento.valor.equals(null) || movimiento.valor.equals(0) || movimiento.saldo.equals(null)
				|| movimiento.saldo.equals(0D) || movimiento.saldo < 0)
			throw new MovimientoException(MOVIMIENTO_INFO_SERVICIO_CREAR_OBJETO_MOVIMIENTO_NULO_O_VACIO);
		if (movimiento.valor <= 0)
			throw new MovimientoException(MOVIMIENTO_INFO_SERVICIO_CREAR_OBJETO_VALOR_DEBE_SER_POSITIVO);
		if (movimiento.saldo <= 0)
			throw new MovimientoException(MOVIMIENTO_INFO_SERVICIO_CREAR_OBJETO_SALDO_DEBE_SER_POSITIVO);

		setFechaActual(movimiento);
		movimientoDao.save(movimiento);
	}

	@Override
	@Transactional(rollbackFor = { SQLException.class })
	public void actualizar(Movimiento movimiento) throws MovimientoException, RestClientException {
		if (movimientoIdIgualACero(movimiento))
			throw new MovimientoException(MOVIMIENTO_INFO_SERVICIO_ACTUALIZAR_ID_CUENTA_VACIO);
		if (movimientoIdMenorACero(movimiento))
			throw new MovimientoException(MOVIMIENTO_INFO_SERVICIO_ACTUALIZAR_ID_CUENTA_DEBE_SER_MAYOR_A_CERO);
		setFechaActual(movimiento);
		movimientoDao.save(movimiento);
	}

	@Override
	@Transactional(rollbackFor = { SQLException.class })
	public void eliminar(Movimiento movimiento) throws MovimientoException, RestClientException {
		if (movimientoIdIgualACero(movimiento))
			throw new MovimientoException(MOVIMIENTO_INFO_SERVICIO_ELIMINAR_ID_CUENTA_VACIO);
		if (movimientoIdMenorACero(movimiento))
			throw new MovimientoException(MOVIMIENTO_INFO_SERVICIO_ELIMINAR_ID_CUENTA_DEBE_SER_MAYOR_A_CERO);
		movimientoDao.delete(movimiento);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movimiento> listar() throws MovimientoException, RestClientException {
		List<Movimiento> movimientoList = (List<Movimiento>) movimientoDao.findAll();
		if (movimientoList.isEmpty())
			throw new MovimientoException(
					MOVIMIENTO_INFO_SERVICIO_CONSULTAR_TODO_CUENTA_NO_HAY_EXISTENCIA_DE_REGISTROS);
		return movimientoList;
	}

	private Movimiento setFechaActual(Movimiento movimiento) {
		movimiento.fecha = LocalDate.now();
		return movimiento;
	}

	private Boolean movimientoIdIgualACero(Movimiento movimiento) {
		return movimiento.movimientoId.equals(0L);
	}

	private Boolean movimientoIdMenorACero(Movimiento movimiento) {
		return movimiento.movimientoId < 0;
	}
}
