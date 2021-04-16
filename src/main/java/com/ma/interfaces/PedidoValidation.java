package com.ma.interfaces;

import java.util.Optional;

import com.ma.pedidos.model.Pedido;

@FunctionalInterface
public interface PedidoValidation {

	Optional<String> validate(final Pedido pedido);
	
}