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
    @Column(name = "id")
    private Long id;

    @Column (name = "fecha", nullable = false)
    private Date fecha;

    @Column (name = "tipoMovimiento", nullable = false)
    private String tipoMovimiento;

    @Column (name = "valor", nullable = false)
    private Double valor;

    @Column (name = "saldo", nullable = false)
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "numeroCuenta", nullable = false)
    private CuentaEntity cuentaEntity;

}