package com.tiendaapip.marketplat.persistences.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name ="categorias")
public class Categoria
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    private String descripcion;
    private Double estado;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
}
