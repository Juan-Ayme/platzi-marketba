package com.tiendaapip.marketplat.persistences.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "compras_productos")
public class ComprasProducto
{
    @EmbeddedId
    private ComprasProductoPK id;

    private Integer cantidad;
    private Double total;
    private Double estado;

    @ManyToOne
    @JoinColumn(name = "id_compra",insertable = false,updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto",insertable = false,updatable = false)
    private Producto producto;
}
