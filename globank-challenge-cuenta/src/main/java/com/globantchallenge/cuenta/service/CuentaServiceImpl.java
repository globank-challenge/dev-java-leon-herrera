package com.globantchallenge.cuenta.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestClientException;

import com.globantchallenge.cuenta.config.exception.CuentaException;
import com.globantchallenge.cuenta.model.dao.CuentaDao;
import com.globantchallenge.cuenta.model.entity.Cuenta;
import com.google.common.base.Strings;

@Service
public class CuentaServiceImpl implements CuentaService {

	private static final String CUENTA_INFO_SERVICIO_CREAR_OBJETO_CUENTA_NULO_O_VACIO = "La información de la cuenta debe estar completa para crear el registro";
	private static final String CUENTA_INFO_SERVICIO_CREAR_OBJETO_SALDO_DEBE_SER_POSITIVO = "Debe tener un saldo inicial a favor para abrir la cuenta";
	private static final String CUENTA_INFO_SERVICIO_ACTUALIZAR_ID_CUENTA_VACIO = "Debe ingresar id del registro Cuenta a actualizar";
	private static final String CUENTA_INFO_SERVICIO_ACTUALIZAR_ID_CUENTA_DEBE_SER_MAYOR_A_CERO = "El id de la cuenta a actualizar debe ser mayor a 0";
	private static final String CUENTA_INFO_SERVICIO_ELIMINAR_ID_CUENTA_VACIO = "El id del registro Cuenta a eliminar no puede estar vacio";
	private static final String CUENTA_INFO_SERVICIO_ELIMINAR_ID_CUENTA_DEBE_SER_MAYOR_A_CERO = "El id de la cuenta a eliminar debe ser mayor a 0";
	private static final String CUENTA_INFO_SERVICIO_CONSULTAR_TODO_CUENTA_NO_HAY_EXISTENCIA_DE_REGISTROS = "No hay existencia de cuentas en la base de datos";

	@Autowired
	private CuentaDao cuentaDao;

	@Override
	@Transactional(rollbackFor = { SQLException.class })
	public void crear(Cuenta cuenta) throws CuentaException, RestClientException {
		if (ObjectUtils.isEmpty(cuenta) || Strings.isNullOrEmpty(cuenta.numeroCuenta)
				|| Strings.isNullOrEmpty(cuenta.tipoCuenta) || cuenta.saldoInicial.equals(null)
				|| cuenta.saldoInicial.equals(0D) || cuenta.saldoInicial < 0 || ObjectUtils.isEmpty(cuenta.estado) || Strings.isNullOrEmpty(cuenta.nombre))
			throw new CuentaException(CUENTA_INFO_SERVICIO_CREAR_OBJETO_CUENTA_NULO_O_VACIO);
		if(saldoInicialMenorOIgualACero(cuenta)) throw new CuentaException(CUENTA_INFO_SERVICIO_CREAR_OBJETO_SALDO_DEBE_SER_POSITIVO);
		cuentaDao.save(cuenta);
	}

	@Override
	@Transactional(rollbackFor = { SQLException.class })
	public void actualizar(Cuenta cuenta) throws CuentaException, RestClientException {
		if(cuentaIdIgualACero(cuenta)) throw new CuentaException(CUENTA_INFO_SERVICIO_ACTUALIZAR_ID_CUENTA_VACIO);
		if(cuentaIdMenorACero(cuenta)) throw new CuentaException(CUENTA_INFO_SERVICIO_ACTUALIZAR_ID_CUENTA_DEBE_SER_MAYOR_A_CERO);
		cuentaDao.save(cuenta);
	}

	@Override
	@Transactional(rollbackFor = { SQLException.class })
	public void eliminar(Cuenta cuenta) throws CuentaException, RestClientException {
		if(cuentaIdIgualACero(cuenta)) throw new CuentaException(CUENTA_INFO_SERVICIO_ELIMINAR_ID_CUENTA_VACIO);
		if(cuentaIdMenorACero(cuenta)) throw new CuentaException(CUENTA_INFO_SERVICIO_ELIMINAR_ID_CUENTA_DEBE_SER_MAYOR_A_CERO);
		cuentaDao.delete(cuenta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> listar() throws CuentaException, RestClientException {
		List<Cuenta> cuentaList = (List<Cuenta>) cuentaDao.findAll();
		if(cuentaList.isEmpty()) throw new CuentaException(CUENTA_INFO_SERVICIO_CONSULTAR_TODO_CUENTA_NO_HAY_EXISTENCIA_DE_REGISTROS);
		return cuentaList;
	}

	private Boolean cuentaIdIgualACero(Cuenta cuenta) {
		return cuenta.cuentaId.equals(0L);
	}

	private Boolean cuentaIdMenorACero(Cuenta cuenta) {
		return cuenta.cuentaId < 0;
	}

	private Boolean saldoInicialMenorOIgualACero (Cuenta cuenta) {
		return cuenta.saldoInicial <= 0;
	}
}
