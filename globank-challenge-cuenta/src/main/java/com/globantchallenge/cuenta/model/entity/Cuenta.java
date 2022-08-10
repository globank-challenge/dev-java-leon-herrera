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
import lombok.Getter;
import lombok.Setter;

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
	public Long cuentaId;

	@Column(name = "numero_cuenta")
	public String numeroCuenta;
	
	@Column(name = "tipo_cuenta")
	public String tipoCuenta;
	
	@Column(name =  "saldo_inicial")
	public Double saldoInicial;
	
	@Column(name = "estado")
	public Boolean estado;

	private static final long serialVersionUID = 7258922994301755560L;
}
