package com.tiendaapip.marketplat.persistences.crud;

import com.tiendaapip.marketplat.persistences.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoJpaRepository extends JpaRepository<Producto,Long>
{
    List<Producto> findByIdCategoriaOrderByNombreAsc(Long idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Integer cantidadStock,Boolean estado);
}
