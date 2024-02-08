package com.gestionproductos.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionproductos.models.entity.Producto;
@Repository
public interface repositoryProduct extends CrudRepository<Producto, Long> {
}
