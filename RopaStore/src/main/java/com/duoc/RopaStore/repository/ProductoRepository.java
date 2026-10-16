package com.duoc.RopaStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.RopaStore.model.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findBySucursalId(Long sucursalId);
}

