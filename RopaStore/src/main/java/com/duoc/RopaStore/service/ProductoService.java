package com.duoc.RopaStore.service;

import org.springframework.stereotype.Service;

import com.duoc.RopaStore.model.Producto;
import com.duoc.RopaStore.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto datos) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto == null) return null;
        producto.setNombre(datos.getNombre());
        producto.setCategoria(datos.getCategoria());
        producto.setPrecio(datos.getPrecio());
        producto.setStock(datos.getStock());
        producto.setSucursalId(datos.getSucursalId());
        return productoRepository.save(producto);
    }

    public boolean eliminarProducto(Long id) {
        if (!productoRepository.existsById(id)) return false;
        productoRepository.deleteById(id);
        return true;
    }

    public List<Producto> listarPorSucursal(Long sucursalId) {
        return productoRepository.findBySucursalId(sucursalId);
    }
}