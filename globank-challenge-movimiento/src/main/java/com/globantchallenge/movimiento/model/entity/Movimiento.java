package com.globantchallenge.movimiento.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "movimiento")
public class Movimiento implements Serializable{
	
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long movimientoId;
	
	@Column(name = "fecha")
	public LocalDate fecha;
	
	@Column(name = "tipoMovimiento")
	public String tipoMovimiento;
	
	@Column(name = "valor")
	public Double valor;
	
	@Column(name = "saldo")
	public Double saldo;

	private static final long serialVersionUID = 1067185147213812933L;
}
