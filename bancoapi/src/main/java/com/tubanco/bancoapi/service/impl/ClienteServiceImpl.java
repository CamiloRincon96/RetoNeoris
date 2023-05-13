package com.tubanco.bancoapi.service.impl;

import com.tubanco.bancoapi.dto.ClienteCuentaMovimientoDto;
import com.tubanco.bancoapi.dto.ClienteDto;
import com.tubanco.bancoapi.entity.ClienteEntity;
import com.tubanco.bancoapi.entity.CuentaEntity;
import com.tubanco.bancoapi.entity.MovimientoEntity;
import com.tubanco.bancoapi.exception.ResourceNotFoundException;
import com.tubanco.bancoapi.repository.ClienteRepository;
import com.tubanco.bancoapi.repository.CuentaRepository;
import com.tubanco.bancoapi.repository.MovimientoRepository;
import com.tubanco.bancoapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    @Transactional
    public ClienteDto saveCliente(ClienteDto clienteDto) {
        ClienteEntity cliente = new ClienteEntity();
        copyDtoToEntity(clienteDto, cliente);

        ClienteEntity savedCliente = clienteRepository.save(cliente);
        return copyEntityToDto(savedCliente);
    }

    @Transactional
    @Override
    public List<ClienteCuentaMovimientoDto> getClientMovements(
            Long clienteId, Date fechaInicio, Date fechaFin) {

        List<CuentaEntity> cuentas = cuentaRepository.findByClienteId(clienteId);

        ClienteEntity cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        List<ClienteCuentaMovimientoDto> dtos = new ArrayList<>();

        for (CuentaEntity cuenta : cuentas) {

            List<MovimientoEntity> movimientos = movimientoRepository.findByCuentaIdAndFechaBetween(
                    cuenta.getId(), fechaInicio, fechaFin);

            double totalMovimientos = movimientos.stream()
                    .mapToDouble(mov -> mov.getTipoMovimiento().equals("credito") ? mov.getValor() :
                            -mov.getValor())
                    .sum();

            ClienteCuentaMovimientoDto dto = new ClienteCuentaMovimientoDto();
            dto.setFechaCliente(new SimpleDateFormat(
                    "dd/MM/yyyy").format(cliente.getFecha()));
            dto.setCliente(cliente.getNombre());
            dto.setNumeroCuenta(cuenta.getNumeroCuenta());
            dto.setTipo(cuenta.getTipoCuenta());
            dto.setSaldoInicial(cuenta.getSaldoInicial());
            dto.setEstadoMovimiento(cuenta.getEstado());
            dto.setMovimiento(totalMovimientos);
            dto.setSaldoDisponible(cuenta.getSaldoInicial() + totalMovimientos);

            dtos.add(dto);
        }

        return dtos;
    }


    private void copyDtoToEntity(ClienteDto dto, ClienteEntity entity) {
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setGenero(dto.getGenero());
        entity.setEdad(dto.getEdad());
        entity.setIdentificacion(dto.getIdentificacion());
        entity.setDireccion(dto.getDireccion());
        entity.setTelefono(dto.getTelefono());
        entity.setContrasena(dto.getContrasena());
        entity.setEstado(dto.getEstado());
    }

    private ClienteDto copyEntityToDto(ClienteEntity entity) {
        ClienteDto dto = new ClienteDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setGenero(entity.getGenero());
        dto.setEdad(entity.getEdad());
        dto.setIdentificacion(entity.getIdentificacion());
        dto.setDireccion(entity.getDireccion());
        dto.setTelefono(entity.getTelefono());
        dto.setContrasena(entity.getContrasena());
        dto.setEstado(entity.getEstado());
        return dto;
    }
}

