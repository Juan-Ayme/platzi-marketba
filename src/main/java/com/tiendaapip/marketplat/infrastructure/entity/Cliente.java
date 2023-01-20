package com.tiendaapip.marketplat.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "clientes")
public class Cliente
{
    @Id
    private String id;

    private String nombre;
    private String apellido;
    private Long celular;
    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
}
