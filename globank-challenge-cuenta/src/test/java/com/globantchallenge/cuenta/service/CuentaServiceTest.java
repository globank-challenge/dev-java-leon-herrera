package com.globantchallenge.cuenta.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.globantchallenge.cuenta.config.exception.CuentaException;
import com.globantchallenge.cuenta.model.entity.Cuenta;

@ExtendWith(MockitoExtension.class)
public class CuentaServiceTest {

	@InjectMocks
	static CuentaService cuentaService;

	@Mock
	Cuenta cuenta;

	@BeforeAll
	static void setup() {
		cuentaService = new CuentaServiceImpl();
	}

	/**
	 * Probando transacción crear
	 */
	@Test
	void givenNullCuentaAtCrear_throwsCuentaException() {
		assertThrows(CuentaException.class, () -> cuentaService.crear(cuenta));
	}

	@Test
	void givenNullNumeroCuentaAtCrear_throwsCuentaException() {
		cuenta.numeroCuenta = null;
		assertThrows(CuentaException.class, () -> cuentaService.crear(cuenta));
	}
	
	@Test
	void givenNullTipoCuentaAtCrear_throwsCuentaException() {
		cuenta.tipoCuenta = null;
		assertThrows(CuentaException.class, () -> cuentaService.crear(cuenta));
	}

	@Test
	void givenNullSaldoInicialAtCrear_throwsCuentaException() {
		cuenta.saldoInicial = null;
		assertThrows(CuentaException.class, () -> cuentaService.crear(cuenta));
	}

	@Test
	void givenZeroAsSaldoInicialAtCrear_throwsCuentaException() {
		cuenta.saldoInicial = 0D;
		assertThrows(CuentaException.class, () -> cuentaService.crear(cuenta));
	}
	
	@Test
	void givenNegativeValueAsSaldoInicialAtCrear_throwsCuentaException() {
		cuenta.saldoInicial = -9D;
		assertThrows(CuentaException.class, () -> cuentaService.crear(cuenta));
	}
	
	@Test
	void givenNullEstadoAtCrear_throwsCuentaException() {
		cuenta.estado = null;
		assertThrows(CuentaException.class, () -> cuentaService.crear(cuenta));
	}
	
	@Test
	void givenNullNombreAtCrear_throwsCuentaException() {
		cuenta.nombre = null;
		assertThrows(CuentaException.class, () -> cuentaService.crear(cuenta));
	}
	
	/**
	 * Probando transacción actualizar
	 */	
	@Test
	void givenZeroValueAsCuentaIdAtActualizar_throwsCuentaException() {
		cuenta.cuentaId = 0L;
		assertThrows(CuentaException.class, () -> cuentaService.actualizar(cuenta));
	}
	
	@Test
	void givenNegativeValueAsCuentaIdAtActualizar_throwsCuentaException() {
		cuenta.cuentaId = -5L;
		assertThrows(CuentaException.class, () -> cuentaService.actualizar(cuenta));
	}
	
	/**
	 * Probando transacción eliminar
	 */
	@Test
	void givenZeroAsCuentaIdAtEliminar_throwsCuentaException() {
		cuenta.cuentaId = 0L;
		assertThrows(CuentaException.class, () -> cuentaService.actualizar(cuenta));
	}

	@Test
	void givenNegativeValueAsCuentaIdAtEliminar_throwsCuentaException() {
		cuenta.cuentaId = -5L;
		assertThrows(CuentaException.class, () -> cuentaService.actualizar(cuenta));
	}

}
