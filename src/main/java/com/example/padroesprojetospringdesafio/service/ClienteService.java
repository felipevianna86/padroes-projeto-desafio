package com.example.padroesprojetospringdesafio.service;

import com.example.padroesprojetospringdesafio.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();
    Cliente buscaById(Long id);
    Cliente inserir(Cliente cliente);
    Cliente atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
