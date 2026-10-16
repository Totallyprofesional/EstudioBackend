package com.duoc.RopaStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.RopaStore.model.Cliente;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByRut(String rut);
}

