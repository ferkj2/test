package com.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ma.pedidos.model.PedidoDetalle;

public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle, Long> {

}
