package com.tiendaapip.marketplat.persistences.mapper;

import com.tiendaapip.marketplat.domain.model.Product;
import com.tiendaapip.marketplat.persistences.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CategoryMapper.class})
public interface ProductMapper
{

    @Mappings(
            {
                    @Mapping(source = "idProducto",target ="productId"),
                    @Mapping(source = "nombre",target = "name"),
                    @Mapping(source = "idCategoria",target = "categoryId"),
                    @Mapping(source = "precioVenta",target = "price"),
                    @Mapping(source = "cantidadStock",target = "stock"),
                    @Mapping(source = "estado",target = "active"),
                    //como category ya tiene su mapper vamos a incluirlo
                    @Mapping(source = "categoria",target = "category")
            }
    )
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @Mapping(target = "codigoBarras",ignore = true)//cuando se convierte un product a un producto ignoramos el codigo de barras
    @InheritInverseConfiguration
    Producto toProducto(Product product);

}
