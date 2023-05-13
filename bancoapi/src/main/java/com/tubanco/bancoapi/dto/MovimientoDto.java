package com.tubanco.bancoapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date fecha;
    private String tipoMovimiento;
    private Double valor;
    private Double saldo;
    private Long cuentaId;

}
