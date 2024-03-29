package com.kloster.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente getCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizarCliente(Long id, Cliente cliente) {
        Cliente clienteExistente = getCliente(id);
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEndereco(cliente.getEndereco());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setSenha(cliente.getSenha());
        return clienteRepository.save(clienteExistente);
    }

    public void deletarCliente(Long id) {
        Cliente cliente = getCliente(id);
        clienteRepository.delete(cliente);
    }
}
