package com.tubanco.bancoapi.repository;

import com.tubanco.bancoapi.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
