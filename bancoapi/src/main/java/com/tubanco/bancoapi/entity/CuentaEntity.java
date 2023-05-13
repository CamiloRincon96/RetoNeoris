package com.tubanco.bancoapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuenta")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroCuenta")
    private Long numeroCuenta;

    @Column (name = "tipoCuenta", nullable = false)
    private String tipoCuenta;

    @Column (name = "saldoInicial", nullable = false)
    private Double saldoInicial;

    @Column (name = "estado", nullable = false)
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "clienteId", nullable = false)
    private ClienteEntity clienteEntity;


}
