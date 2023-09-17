package com.example.padroesprojetospringdesafio.service;

import com.example.padroesprojetospringdesafio.model.Endereco;
import com.example.padroesprojetospringdesafio.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco findEnderecoByCep(String cep){
        return this.enderecoRepository.findById(cep).orElse(null);
    }

    public Endereco salvarEndereco(Endereco endereco){
        return this.enderecoRepository.save(endereco);
    }
}
