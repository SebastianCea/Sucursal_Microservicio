package com.example.microservicios.model;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name = "Sucursales")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sucursal;

    @Column(length = 20, nullable = false)
    private String nombre_sucursal;

     @Column(length = 20, nullable = false)
    private String direccion_sucursal;

     @Column(length = 20, nullable = false)
    private String region_sucursal;

     @Column(nullable = false)
    private LocalTime hora_apertura;

    @Column(nullable = false)
    private LocalTime hora_cierre;
}
