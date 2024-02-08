package com.gestionproductos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class controllerAdvice {
	@ExceptionHandler(ProductoNoEncontradoException.class)
	public ResponseEntity<String> manejarProductoNoEncontrado(ProductoNoEncontradoException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
