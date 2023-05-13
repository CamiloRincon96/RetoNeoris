package com.tubanco.bancoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDto {

    private Long numeroCuenta;
    private String tipoCuenta;
    private double saldoInicial;
    private boolean estado;
    private Long clienteId; // este campo representa la relación con la entidad Cliente
}