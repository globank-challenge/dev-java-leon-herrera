package com.globantchallenge.cliente.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.globantchallenge.cliente.model.Persona;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cliente")
public class Cliente extends Persona implements Serializable{

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long clienteId;
	
	@Column(name = "contrasenia")
	public String contrasenia;
	
	@Column(name = "estado")
	public Boolean estado;
	
	private static final long serialVersionUID = 6787197296979690274L;
}
