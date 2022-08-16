package com.globantchallenge.movimiento.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.globantchallenge.movimiento.config.exception.MovimientoException;
import com.globantchallenge.movimiento.model.entity.Movimiento;

@ExtendWith(MockitoExtension.class)
public class MovimientoServiceTest {
	
	@InjectMocks
	static MovimientoService movimientoService;
	
	@Mock
	Movimiento movimiento;
	
	@BeforeAll
	static void setup() {
		movimientoService = new MovimientoServiceImpl();
	}

	/**
	 * Probando transacción crear
	 */
	@Test
	void givenNullMovimientoAtCrear_throwsCuentaException() {
		assertThrows(MovimientoException.class, () -> movimientoService.crear(movimiento));
	}

	@Test
	void givenNullTipoMovimientoAtCrear_throwsCuentaException() {
		movimiento.tipoMovimiento = null;
		assertThrows(MovimientoException.class, () -> movimientoService.crear(movimiento));
	}
	
	@Test
	void givenNullValueAsValorAtCrear_throwsCuentaException() {
		movimiento.valor = null;
		assertThrows(MovimientoException.class, () -> movimientoService.crear(movimiento));
	}
	
	@Test
	void givenZeroValueAsValorAtCrear_throwsCuentaException() {
		movimiento.valor = 0D;
		assertThrows(MovimientoException.class, () -> movimientoService.crear(movimiento));
	}
	
	@Test
	void givenNegativeValueAsValorAtCrear_throwsCuentaException() {
		movimiento.valor = -15D;
		assertThrows(MovimientoException.class, () -> movimientoService.crear(movimiento));
	}
	
	@Test
	void givenNullValueAsSaldoAtCrear_throwsCuentaException() {
		movimiento.saldo = null;
		assertThrows(MovimientoException.class, () -> movimientoService.crear(movimiento));
	}
	
	@Test
	void givenZeroValueAsSaldoAtCrear_throwsCuentaException() {
		movimiento.saldo = 0D;
		assertThrows(MovimientoException.class, () -> movimientoService.crear(movimiento));
	}
	
	@Test
	void givenNegativeValueAsSaldoAtCrear_throwsCuentaException() {
		movimiento.saldo = -15D;
		assertThrows(MovimientoException.class, () -> movimientoService.crear(movimiento));
	}

	/**
	 * Probando transacción actualizar
	 */	
	@Test
	void givenZeroValueAsMovimientoIdAtActualizar_throwsCuentaException() {
		movimiento.movimientoId = 0L;
		assertThrows(MovimientoException.class, () -> movimientoService.actualizar(movimiento));
	}

	@Test
	void givenNegativeValueAsMovimientoIdAtActualizar_throwsCuentaException() {
		movimiento.movimientoId = -7L;
		assertThrows(MovimientoException.class, () -> movimientoService.actualizar(movimiento));
	}

	/**
	 * Probando transacción eliminar
	 */	
	@Test
	void givenZeroValueAsMovimientoIdAtEliminar_throwsCuentaException() {
		movimiento.movimientoId = 0L;
		assertThrows(MovimientoException.class, () -> movimientoService.eliminar(movimiento));
	}
	
	@Test
	void givenNegativeValueAsMovimientoIdAtElimiunar_throwsCuentaException() {
		movimiento.movimientoId = -7L;
		assertThrows(MovimientoException.class, () -> movimientoService.eliminar(movimiento));
	}
	
}
