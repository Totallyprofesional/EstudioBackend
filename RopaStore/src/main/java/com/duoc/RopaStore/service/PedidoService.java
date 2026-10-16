package com.duoc.RopaStore.service;

import org.springframework.stereotype.Service;

import com.duoc.RopaStore.model.Pedido;
import com.duoc.RopaStore.repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> listarPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido actualizarPedido(Long id, Pedido datos) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido == null) return null;
        pedido.setClienteId(datos.getClienteId());
        pedido.setFechaPedido(datos.getFechaPedido());
        pedido.setTotal(datos.getTotal());
        pedido.setEstado(datos.getEstado());
        return pedidoRepository.save(pedido);
    }

    public boolean eliminarPedido(Long id) {
        if (!pedidoRepository.existsById(id)) return false;
        pedidoRepository.deleteById(id);
        return true;
    }
}