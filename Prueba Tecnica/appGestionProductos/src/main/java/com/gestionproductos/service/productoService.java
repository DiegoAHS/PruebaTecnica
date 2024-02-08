package com.gestionproductos.service;

import com.gestionproductos.models.entity.Producto;

public interface productoService {
	
	Iterable<Producto> getAllProducts();
	
	public Producto getProductById(Long id);
	
	public Producto addProduct(Producto producto);
	
	public Producto updateProduct(Long id, Producto producto);
	
	public void removeProduct(Long id);

}
