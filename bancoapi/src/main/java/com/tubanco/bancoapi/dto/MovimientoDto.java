package com.tubanco.bancoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoDto {

    private Long id;
    private Date fecha;
    private String tipoMovimiento;
    private double valor;
    private double saldo;
    private Long numeroCuenta; // este campo representa la relación con la entidad Cuenta
}
