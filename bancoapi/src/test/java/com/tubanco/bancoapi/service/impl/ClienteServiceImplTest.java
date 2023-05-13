package com.tubanco.bancoapi.service.impl;

import com.tubanco.bancoapi.dto.ClienteDto;
import com.tubanco.bancoapi.entity.ClienteEntity;
import com.tubanco.bancoapi.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    public void testSaveCliente() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombre("Juan");

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNombre("Juan");

        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(clienteEntity);

        ClienteDto result = clienteService.saveCliente(clienteDto);

        assertNotNull(result);
        assertEquals("Juan", result.getNombre());

        verify(clienteRepository, times(1)).save(any(ClienteEntity.class));
    }
}
