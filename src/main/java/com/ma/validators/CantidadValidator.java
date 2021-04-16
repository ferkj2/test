package com.ma.validators;

import java.util.Optional;

import com.ma.interfaces.PedidoValidation;
import com.ma.pedidos.model.Pedido;
import com.ma.pedidos.model.PedidoDetalle;

public class CantidadValidator implements PedidoValidation {

	@Override
	public Optional<String> validate(Pedido pedido) {
		
		for (PedidoDetalle detalle : pedido.getDetalle()) {
			if(detalle.getCantidad()==null){
				return Optional.of("Falta ingresar cantidad");
	        }
		}
		
		return Optional.empty();
	}

}
