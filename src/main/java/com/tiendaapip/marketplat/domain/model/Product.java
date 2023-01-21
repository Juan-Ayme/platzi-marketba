package com.tiendaapip.marketplat.domain.model;

import lombok.Data;

@Data
public class Product
{
    private Long productoId;
    private String name;
    private Integer categoryId;
    private Double price;
    private Integer stock;
    private Boolean active;
    private Category category;

}
