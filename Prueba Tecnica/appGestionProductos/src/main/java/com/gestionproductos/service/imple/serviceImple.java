package com.gestionproductos.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionproductos.models.entity.Producto;
import com.gestionproductos.repository.repositoryProduct;
import com.gestionproductos.service.productoService;

@Service
public class serviceImple implements productoService {
	
	@Autowired
	private repositoryProduct productR;

	@Override
	public Iterable<Producto> getAllProducts() {
		// TODO Auto-generated method stub
		return productR.findAll();
	}

	@Override
	public Producto getProductById(Long id) {
		// TODO Auto-generated method stub
		return productR.findById(id).orElse(null);
	}

	@Override
	public Producto addProduct(Producto producto) {
		// TODO Auto-generated method stub
		return productR.save(producto);
	}

	@Override
	public Producto updateProduct(Long id, Producto producto) { 
		Producto toProduct = getProductById(id);
		mapUser(producto,toProduct);
		return productR.save(toProduct);
	}
	
	public void mapUser(Producto from, Producto to) {
		to.setNombre(from.getNombre());
		to.setPrecio(from.getPrecio());
	}

	@Override
	public void removeProduct(Long id) {
		Producto producto = getProductById(id);
		productR.delete(producto);
		
	}

}
