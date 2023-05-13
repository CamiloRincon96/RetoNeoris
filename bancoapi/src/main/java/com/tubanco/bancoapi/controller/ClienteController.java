package com.tubanco.bancoapi.controller;

import com.tubanco.bancoapi.dto.ClienteDto;
import com.tubanco.bancoapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDto> createCliente(@Validated @RequestBody ClienteDto clienteDto) {
        ClienteDto savedCliente = clienteService.saveCliente(clienteDto);
        return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable(value = "id") Long clienteId) {
        ClienteDto cliente = clienteService.findClienteById(clienteId);
        return ResponseEntity.ok().body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> updateCliente(@PathVariable(value = "id") Long clienteId,
                                                    @Validated @RequestBody ClienteDto clienteDetails) {
        ClienteDto updatedCliente = clienteService.updateCliente(clienteId, clienteDetails);
        return ResponseEntity.ok().body(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable(value = "id") Long clienteId) {
        clienteService.deleteCliente(clienteId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAllClientes() {
        List<ClienteDto> clientes = clienteService.findAllClientes();
        return ResponseEntity.ok().body(clientes);
    }
}