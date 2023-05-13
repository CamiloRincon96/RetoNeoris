package com.tubanco.bancoapi.service;

import com.tubanco.bancoapi.dto.ClienteCuentaMovimientoDto;
import com.tubanco.bancoapi.dto.ClienteDto;

import java.util.Date;
import java.util.List;

public interface ClienteService {

    ClienteDto saveCliente(ClienteDto clienteDto);

    List<ClienteCuentaMovimientoDto> getClientMovements(
            Long clienteId, Date fechaInicio, Date fechaFin);

}