package com.tubanco.bancoapi.service.impl;

import com.tubanco.bancoapi.dto.MovimientoDto;
import com.tubanco.bancoapi.entity.CuentaEntity;
import com.tubanco.bancoapi.entity.MovimientoEntity;
import com.tubanco.bancoapi.exception.InsufficientFundsException;
import com.tubanco.bancoapi.exception.ResourceNotFoundException;
import com.tubanco.bancoapi.repository.CuentaRepository;
import com.tubanco.bancoapi.repository.MovimientoRepository;
import com.tubanco.bancoapi.service.MovimientoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Transactional
    public MovimientoDto makeMovement(Long cuentaId, Double valor, String tipoMovimiento) {
        CuentaEntity cuenta = cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada"));

        if (tipoMovimiento.equals("debito") && cuenta.getSaldoInicial() < valor) {
            throw new InsufficientFundsException("Saldo no disponible");
        }

        int sign = tipoMovimiento.equals("credito") ? 1 : -1;
        Double nuevoSaldo = cuenta.getSaldoInicial() + sign * valor;
        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);

        MovimientoEntity movimiento = new MovimientoEntity();
        movimiento.setTipoMovimiento(tipoMovimiento);
        movimiento.setValor(valor);
        movimiento.setCuenta(cuenta);
        movimiento.setFecha(new Date());
        movimiento.setSaldo(nuevoSaldo);

        MovimientoEntity savedMovimiento = movimientoRepository.save(movimiento);
        return copyEntityToDto(savedMovimiento);
    }

    private MovimientoDto copyEntityToDto(MovimientoEntity entity) {
        MovimientoDto dto = new MovimientoDto();
        dto.setId(entity.getId());
        dto.setValor(entity.getValor());
        dto.setTipoMovimiento(entity.getTipoMovimiento());
        dto.setFecha(entity.getFecha());
        dto.setCuentaId(entity.getCuenta().getId());
        dto.setFecha(entity.getFecha());
        dto.setSaldo(entity.getSaldo());
        return dto;
    }

}


