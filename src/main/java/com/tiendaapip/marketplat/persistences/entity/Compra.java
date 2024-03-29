package com.tiendaapip.marketplat.persistences.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "compras")
public class Compra
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente",insertable = false,updatable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "compra")
    private List<ComprasProducto> productos;

}
