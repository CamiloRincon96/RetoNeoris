package com.tubanco.bancoapi.service.impl;

import com.tubanco.bancoapi.dto.CuentaDto;
import com.tubanco.bancoapi.entity.ClienteEntity;
import com.tubanco.bancoapi.entity.CuentaEntity;
import com.tubanco.bancoapi.exception.ResourceNotFoundException;
import com.tubanco.bancoapi.repository.ClienteRepository;
import com.tubanco.bancoapi.repository.CuentaRepository;
import com.tubanco.bancoapi.service.CuentaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    @Transactional
    public CuentaDto saveCuenta(CuentaDto cuentaDto) {
        CuentaEntity cuenta = new CuentaEntity();
        copyDtoToEntity(cuentaDto, cuenta);

        CuentaEntity savedCuenta = cuentaRepository.save(cuenta);
        return copyEntityToDto(savedCuenta);
    }

    private void copyDtoToEntity(CuentaDto dto, CuentaEntity entity) {
        entity.setNumeroCuenta(dto.getNumeroCuenta());
        entity.setTipoCuenta(dto.getTipoCuenta());
        entity.setSaldoInicial(dto.getSaldoInicial());
        entity.setEstado(dto.getEstado());

        ClienteEntity cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        entity.setCliente(cliente);
    }

    private CuentaDto copyEntityToDto(CuentaEntity entity) {
        CuentaDto dto = new CuentaDto();
        dto.setId(entity.getId());
        dto.setNumeroCuenta(entity.getNumeroCuenta());
        dto.setTipoCuenta(entity.getTipoCuenta());
        dto.setSaldoInicial(entity.getSaldoInicial());
        dto.setEstado(entity.getEstado());
        dto.setClienteId(entity.getCliente().getId());
        return dto;
    }

}

