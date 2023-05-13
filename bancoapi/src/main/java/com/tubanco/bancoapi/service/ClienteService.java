package com.tubanco.bancoapi.service;

import com.tubanco.bancoapi.dto.ClienteDto;
import com.tubanco.bancoapi.entity.ClienteEntity;
import com.tubanco.bancoapi.exception.ResourceNotFoundException;
import com.tubanco.bancoapi.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDto saveCliente(ClienteDto clienteDto) {
        ClienteEntity cliente = new ClienteEntity();
        copyDtoToEntity(clienteDto, cliente);
        ClienteEntity savedCliente = clienteRepository.save(cliente);
        return copyEntityToDto(savedCliente);
    }

    public ClienteDto findClienteById(Long clienteId) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(clienteId);
        if (!cliente.isPresent()) {
            throw new ResourceNotFoundException("Cliente no encontrado");
        }
        return copyEntityToDto(cliente.get());
    }

    public ClienteDto updateCliente(Long clienteId, ClienteDto clienteDetails) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(clienteId);
        if (!cliente.isPresent()) {
            throw new ResourceNotFoundException("Cliente no encontrado");
        }
        ClienteEntity clienteToUpdate = cliente.get();
        copyDtoToEntity(clienteDetails, clienteToUpdate);
        ClienteEntity updatedCliente = clienteRepository.save(clienteToUpdate);
        return copyEntityToDto(updatedCliente);
    }

    public void deleteCliente(Long clienteId) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(clienteId);
        if (!cliente.isPresent()) {
            throw new ResourceNotFoundException("Cliente no encontrado");
        }
        clienteRepository.delete(cliente.get());
    }

    public List<ClienteDto> findAllClientes() {
        List<ClienteEntity> clientes = clienteRepository.findAll();
        List<ClienteDto> clienteDtos = new ArrayList<>();
        for (ClienteEntity cliente : clientes) {
            clienteDtos.add(copyEntityToDto(cliente));
        }
        return clienteDtos;
    }

    private void copyDtoToEntity(ClienteDto dto, ClienteEntity entity) {
        entity.setNombre(dto.getNombre());
        entity.setGenero(dto.getGenero());
        entity.setEdad(dto.getEdad());
        entity.setIdentificacion(dto.getIdentificacion());
        entity.setDireccion(dto.getDireccion());
        entity.setTelefono(dto.getTelefono());
        entity.setClienteId(dto.getClienteId());
        entity.setContrasena(dto.getContrasena());
        entity.setEstado(dto.getEstado());
    }

    private ClienteDto copyEntityToDto(ClienteEntity entity) {
        ClienteDto dto = new ClienteDto();
        dto.setNombre(entity.getNombre());
        dto.setGenero(entity.getGenero());
        dto.setEdad(entity.getEdad());
        dto.setIdentificacion(entity.getIdentificacion());
        dto.setDireccion(entity.getDireccion());
        dto.setTelefono(entity.getTelefono());
        dto.setClienteId(entity.getClienteId());
        dto.setContrasena(entity.getContrasena());
        dto.setEstado(entity.getEstado());
        return dto;
    }
}