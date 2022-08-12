package com.globantchallenge.cuenta.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.globantchallenge.cuenta.config.exception.CuentaException;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {
	
	@ExceptionHandler({CuentaException.class, RestClientException.class})
	public ResponseEntity<?> notFoundException(Exception e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

}
