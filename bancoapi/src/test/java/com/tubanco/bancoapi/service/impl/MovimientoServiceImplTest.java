package com.tubanco.bancoapi.service.impl;

import com.tubanco.bancoapi.dto.MovimientoDto;
import com.tubanco.bancoapi.entity.CuentaEntity;
import com.tubanco.bancoapi.entity.MovimientoEntity;
import com.tubanco.bancoapi.repository.CuentaRepository;
import com.tubanco.bancoapi.repository.MovimientoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class MovimientoServiceImplTest {

    @Mock
    private MovimientoRepository movimientoRepository;

    @Mock
    private CuentaRepository cuentaRepository;

    @InjectMocks
    private MovimientoServiceImpl movimientoService;

    @Test
    public void testMakeMovement() {
        CuentaEntity cuenta = new CuentaEntity();
        cuenta.setSaldoInicial(1000.0);

        when(cuentaRepository.findById(any(Long.class))).thenReturn(Optional.of(cuenta));

        when(movimientoRepository.save(any(MovimientoEntity.class))).then(returnsFirstArg());

        MovimientoDto result = movimientoService.makeMovement(1L, 100.0, "credito");

        assertNotNull(result);
        assertEquals(1100.0, result.getSaldo(), 0.01);

        verify(movimientoRepository, times(1)).save(any(MovimientoEntity.class));
    }
}