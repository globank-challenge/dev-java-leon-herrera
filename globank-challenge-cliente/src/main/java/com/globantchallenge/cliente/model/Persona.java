package com.globantchallenge.cliente.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Persona implements Serializable{
	
	/**
	 * 
	 */
	private Long id;
	private String nombre;
	private String genero;
	private Integer edad;
	private String identificacion;
	private String direccion;
	private String telefono;
	
	private static final long serialVersionUID = 4689050743521270046L;
}
