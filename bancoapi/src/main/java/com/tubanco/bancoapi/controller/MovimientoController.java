package com.tubanco.bancoapi.controller;

import com.tubanco.bancoapi.dto.MovimientoDto;
import com.tubanco.bancoapi.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping("/{cuentaId}/{valor}/{tipoMovimiento}")
    public MovimientoDto realizarMovimiento(
            @PathVariable Long cuentaId, @PathVariable Double valor, @PathVariable String tipoMovimiento) {
        return movimientoService.makeMovement(cuentaId, valor, tipoMovimiento);
    }

}

