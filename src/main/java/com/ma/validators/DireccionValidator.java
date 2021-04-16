package com.ma.validators;

import java.util.Optional;

import com.ma.interfaces.PedidoValidation;
import com.ma.pedidos.model.Pedido;

public class DireccionValidator implements PedidoValidation {

	@Override
	public Optional<String> validate(Pedido pedido) {
		if (!pedido.getDireccion().isBlank()) {
            return Optional.empty();
        }
        return Optional.of("La direccion no puede estar vacia");
	}

}
