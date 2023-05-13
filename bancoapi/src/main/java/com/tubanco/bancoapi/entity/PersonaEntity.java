package com.tubanco.bancoapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "persona")
public abstract class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "nombre", nullable = false)
    private String nombre;

    @Column (name = "genero", nullable = false)
    private String genero;

    @Column (name = "edad", nullable = false)
    private int edad;

    @Column (name = "identificacion", nullable = false)
    private String identificacion;

    @Column (name = "direccion", nullable = false)
    private String direccion;

    @Column (name = "telefono", nullable = false)
    private String telefono;

}