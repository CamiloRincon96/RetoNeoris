package com.tubanco.bancoapi.repository;

import com.tubanco.bancoapi.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {

    List<MovimientoEntity> findByCuentaIdAndFechaBetween(Long cuentaId, Date fechaInicio, Date fechaFin);

}
