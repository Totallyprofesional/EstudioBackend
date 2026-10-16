package com.duoc.RopaStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.RopaStore.model.Pedido;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);
}

