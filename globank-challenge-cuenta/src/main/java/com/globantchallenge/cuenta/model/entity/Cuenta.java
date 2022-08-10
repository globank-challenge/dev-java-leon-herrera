package com.globantchallenge.cuenta.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cuenta")
public class Cuenta implements Serializable{
	
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero_cuenta")
	private String numeroCuenta;
	
	@Column(name = "tipo_cuenta")
	private String tipoCuenta;
	
	@Column(name =  "saldo_inicial")
	private Double saldoInicial;
	
	@Column(name = "estado")
	private Boolean estado;

	private static final long serialVersionUID = 7258922994301755560L;
}
