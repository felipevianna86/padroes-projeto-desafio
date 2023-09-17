package com.example.padroesprojetospringdesafio.service.impl;

import com.example.padroesprojetospringdesafio.model.Cliente;
import com.example.padroesprojetospringdesafio.model.Endereco;
import com.example.padroesprojetospringdesafio.repository.ClienteRepository;
import com.example.padroesprojetospringdesafio.service.ClienteService;
import com.example.padroesprojetospringdesafio.service.EnderecoService;
import com.example.padroesprojetospringdesafio.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return this.clienteRepository.findAll();
    }

    @Override
    public Cliente buscaById(Long id) {
        return this.clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        return salvarClienteComCep(cliente);
    }

    @Override
    public Cliente atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteDB = this.clienteRepository.findById(id);

        if(clienteDB.isPresent()){
            return salvarClienteComCep(cliente);
        }

        return null;
    }

    @Override
    public void deletar(Long id) {
        this.clienteRepository.deleteById(id);
    }

    private Cliente salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = this.enderecoService.findEnderecoByCep(cep);

        if(endereco == null){
            endereco = viaCepService.consultarCep(cep);
        }

        cliente.setEndereco(this.enderecoService.salvarEndereco(endereco));
        return this.clienteRepository.save(cliente);
    }
}
