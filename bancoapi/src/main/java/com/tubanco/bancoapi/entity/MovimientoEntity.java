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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movimiento")
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "tipoMovimiento")
    private String tipoMovimiento;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "saldo")
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "cuentaId")
    private CuentaEntity cuenta;

}