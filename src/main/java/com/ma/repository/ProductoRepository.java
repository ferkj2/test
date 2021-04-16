package com.ma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ma.pedidos.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {

	
	
}
