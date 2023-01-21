package com.tiendaapip.marketplat.persistences;

import com.tiendaapip.marketplat.persistences.crud.EntityRepository;
import com.tiendaapip.marketplat.persistences.crud.ProductoJpaRepository;
import com.tiendaapip.marketplat.persistences.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements EntityRepository
{
    private final ProductoJpaRepository productoJpaRepository;

    public ProductoRepository(ProductoJpaRepository productoJpaRepository)
    {
        this.productoJpaRepository = productoJpaRepository;
    }

    @Override
    public List<Producto> getAll() {
        return productoJpaRepository.findAll();
    }

    public List<Producto> getByCategoria(Long idCategoria)
    {
        return productoJpaRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    Optional<List<Producto>> getEscasos(Integer cantidadStock)
    {
        return  productoJpaRepository.findByCantidadStockLessThanAndEstado(cantidadStock,true);
    }

    public Optional<Producto> getProducto(Long idProducto)
    {
        return productoJpaRepository.findById(idProducto);
    }

    public Producto save(Producto producto)
    {
        return productoJpaRepository.save(producto);
    }

    public void delete(Long idProducto)
    {
        productoJpaRepository.deleteById(idProducto);
    }
}
