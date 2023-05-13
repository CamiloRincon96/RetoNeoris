package com.tubanco.bancoapi.controller;

import com.tubanco.bancoapi.dto.CuentaDto;
import com.tubanco.bancoapi.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping
    public CuentaDto createCuenta(@RequestBody CuentaDto cuentaDto) {
        return cuentaService.saveCuenta(cuentaDto);
    }
}

