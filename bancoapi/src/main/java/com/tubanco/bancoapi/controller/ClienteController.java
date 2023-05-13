package com.tubanco.bancoapi.controller;

import com.tubanco.bancoapi.dto.ClienteCuentaMovimientoDto;
import com.tubanco.bancoapi.dto.ClienteDto;
import com.tubanco.bancoapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteDto createCliente(@RequestBody ClienteDto clienteDto) {
        return clienteService.saveCliente(clienteDto);
    }

    @GetMapping("/{id}/clientes")
    public ResponseEntity<List<ClienteCuentaMovimientoDto>> obtenerMovimientosCliente(
            @PathVariable Long id,
            @RequestParam("fechaInicio") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaFin) {

        List<ClienteCuentaMovimientoDto> movimientos = clienteService.getClientMovements(id, fechaInicio, fechaFin);
        return new ResponseEntity<>(movimientos, HttpStatus.OK);
    }
}