package com.tiendaapip.marketplat.persistences.mapper;

import com.tiendaapip.marketplat.domain.model.Category;
import com.tiendaapip.marketplat.persistences.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper
{
    @Mappings(
            {
                    @Mapping(source = "idCategoria",target = "categoryId"),
                    @Mapping(source = "descripcion",target = "categoty"),
                    @Mapping(source = "estado",target = "active")
            }
    )
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos",ignore = true)
    Categoria toCategoria(Category category);
}
