package com.example.padroesprojetospringdesafio.controller;

import com.example.padroesprojetospringdesafio.model.Cliente;
import com.example.padroesprojetospringdesafio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return ResponseEntity.ok(this.clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscaById(@PathVariable Long id){
        return ResponseEntity.ok(this.clienteService.buscaById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserirCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(this.clienteService.inserir(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        return ResponseEntity.ok(this.clienteService.atualizar(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        this.clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
