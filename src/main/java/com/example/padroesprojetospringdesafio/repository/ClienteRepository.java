package com.example.padroesprojetospringdesafio.repository;

import com.example.padroesprojetospringdesafio.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
