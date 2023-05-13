package com.tubanco.bancoapi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuenta")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numeroCuenta", unique = true)
    private String numeroCuenta;

    @Column(name = "tipoCuenta")
    private String tipoCuenta;

    @Column(name = "saldoInicial")
    private Double saldoInicial;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "clienteId", referencedColumnName = "id")
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<MovimientoEntity> movimientos;
}
