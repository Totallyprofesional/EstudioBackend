package com.duoc.RopaStore.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    private LocalDate fechaPedido;
    private int total;
    private String estado;

public Pedido (){}

public Pedido(Long clienteId, LocalDate fechaPedido, int total, String estado) {
    this.clienteId = clienteId;
    this.fechaPedido = fechaPedido;
    this.total = total;
    this.estado = estado;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Long getClienteId() {
    return clienteId;
}

public void setClienteId(Long clienteId) {
    this.clienteId = clienteId;
}

public LocalDate getFechaPedido() {
    return fechaPedido;
}

public void setFechaPedido(LocalDate fechaPedido) {
    this.fechaPedido = fechaPedido;
}

public int getTotal() {
    return total;
}

public void setTotal(int total) {
    this.total = total;
}

public String getEstado() {
    return estado;
}

public void setEstado(String estado) {
    this.estado = estado;
}

}