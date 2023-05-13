package com.tubanco.bancoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCuentaMovimientoDto {

    private String cliente;
    private String fechaCliente;
    private String numeroCuenta;
    private String tipo;
    private Double saldoInicial;
    private Boolean estadoMovimiento;
    private Double saldoDisponible;
    private Double movimiento;

}
