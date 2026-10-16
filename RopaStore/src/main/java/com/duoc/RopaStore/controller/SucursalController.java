package com.duoc.RopaStore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.RopaStore.model.Producto;
import com.duoc.RopaStore.service.ProductoService;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    private final ProductoService productoService;

    public SucursalController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/{sucursalId}/inventario")
    public ResponseEntity<List<Producto>> inventarioPorSucursal(@PathVariable Long sucursalId) {
        return ResponseEntity.ok(productoService.listarPorSucursal(sucursalId));
    }
}