package com.tubanco.bancoapi.repository;

import com.tubanco.bancoapi.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Long> {

    List<CuentaEntity> findByClienteId(Long clienteId);
}
