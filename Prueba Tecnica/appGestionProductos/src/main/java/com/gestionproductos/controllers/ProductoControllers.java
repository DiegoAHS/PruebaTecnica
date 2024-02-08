package com.gestionproductos.controllers;

import org.aopalliance.aop.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.gestionproductos.exception.ProductoNoEncontradoException;
import com.gestionproductos.models.entity.Producto;
import com.gestionproductos.service.productoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/productos")
public class ProductoControllers {

	@Autowired
	private productoService productoService;

	@GetMapping
	public Iterable<Producto> productoForm() {
		return productoService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Producto porId(@PathVariable("id") Long id) {
		Producto producto = productoService.getProductById(id);
		if (producto == null) {
			throw new ProductoNoEncontradoException(id.toString());
		}
		return producto;
	}

	@PostMapping
	public Producto crear(@Valid @RequestBody Producto producto) {
		return productoService.addProduct(producto);
	}

	@PutMapping("/{id}")
	public Producto update(@Valid @PathVariable("id") Long id, @RequestBody Producto producto) {
		Producto validate = porId(id); 
		if(validate == null) {
			throw new ProductoNoEncontradoException(id.toString());
		}
		return productoService.updateProduct(id, producto);
	}

	@DeleteMapping("/{id}")
	public void removerProducto(@PathVariable("id") Long id) {
		Producto producto = porId(id);
		if (producto == null) {
			throw new ProductoNoEncontradoException(id.toString());
		}
		productoService.removeProduct(id);
		
	}

}
