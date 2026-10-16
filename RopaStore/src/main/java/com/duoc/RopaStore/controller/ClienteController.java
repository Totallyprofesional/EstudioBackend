package com.duoc.RopaStore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.duoc.RopaStore.model.Cliente;
import com.duoc.RopaStore.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/{rut}")
    public ResponseEntity<Cliente> buscarPorRut(@PathVariable String rut) {
        Cliente cliente = clienteService.buscarPorRut(rut);
        if (cliente == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.crearCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente actualizado = clienteService.actualizarCliente(id, cliente);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        if (!clienteService.eliminarCliente(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}