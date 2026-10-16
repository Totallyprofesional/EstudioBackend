package com.duoc.RopaStore.service;

import org.springframework.stereotype.Service;

import com.duoc.RopaStore.model.Cliente;
import com.duoc.RopaStore.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorRut(String rut) {
        return clienteRepository.findByRut(rut).orElse(null);
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(Long id, Cliente datos) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) return null;
        cliente.setRut(datos.getRut());
        cliente.setNombre(datos.getNombre());
        cliente.setCorreo(datos.getCorreo());
        cliente.setTelefono(datos.getTelefono());
        cliente.setDireccion(datos.getDireccion());
        return clienteRepository.save(cliente);
    }

    public boolean eliminarCliente(Long id) {
        if (!clienteRepository.existsById(id)) return false;
        clienteRepository.deleteById(id);
        return true;
    }
}