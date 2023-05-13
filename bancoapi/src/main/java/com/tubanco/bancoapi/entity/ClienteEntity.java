package com.tubanco.bancoapi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteEntity extends PersonaEntity {

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "estado")
    private Boolean estado;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<CuentaEntity> cuentas;

    @Column(name = "fecha")
    private Date fecha;
}

