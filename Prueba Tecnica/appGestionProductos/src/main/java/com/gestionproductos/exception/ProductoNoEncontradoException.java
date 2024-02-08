package com.gestionproductos.exception;

import org.springframework.http.HttpStatus;


public class ProductoNoEncontradoException extends RuntimeException {
	
	public ProductoNoEncontradoException(String id) {
		super("Producto no encontrado con ID: " .concat(id));
		// TODO Auto-generated constructor stub
	}
	
	
}
