package com.tubanco.bancoapi.service;

import com.tubanco.bancoapi.dto.MovimientoDto;

public interface MovimientoService {

    public MovimientoDto makeMovement(Long cuentaId, Double valor, String tipoMovimiento);

}
