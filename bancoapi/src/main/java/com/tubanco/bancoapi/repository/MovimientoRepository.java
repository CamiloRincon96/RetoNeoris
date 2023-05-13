package com.tubanco.bancoapi.repository;

import com.tubanco.bancoapi.entity.ClienteEntity;
import com.tubanco.bancoapi.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {
    @Query(     "SELECT m FROM Movimiento m "
            + "WHERE m.fecha BETWEEN :startDate "
            + "AND :endDate AND m.cuenta.cliente = :cliente")
    List<MovimientoEntity> findMovimientosByFechaAndCliente(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate,
            @Param("cliente") ClienteEntity cliente);
}
