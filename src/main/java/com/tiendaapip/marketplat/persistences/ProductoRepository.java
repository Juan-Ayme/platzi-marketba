package com.tiendaapip.marketplat.persistences;

import com.tiendaapip.marketplat.domain.model.Product;
import com.tiendaapip.marketplat.domain.repository.ProductRepository;
import com.tiendaapip.marketplat.persistences.crud.ProductoJpaRepository;
import com.tiendaapip.marketplat.persistences.entity.Producto;
import com.tiendaapip.marketplat.persistences.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository
{
    private final ProductoJpaRepository productoJpaRepository;
    private ProductMapper productMapper;

    public ProductoRepository(ProductoJpaRepository productoJpaRepository)
    {
        this.productoJpaRepository = productoJpaRepository;
    }

    public List<Product> getAll() {
        List<Producto> productos = productoJpaRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(Long category)
    {
        List<Producto> productos = productoJpaRepository.findByIdCategoriaOrderByNombreAsc(category);

        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(Integer quantity)
    {
        Optional<List<Producto>> productos = productoJpaRepository.findByCantidadStockLessThanAndEstado(quantity,true);

        return productos.map(prods-> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(Long productId)
    {
        //.findById devuelve un optional, y una de sus funciones en map de optional que devielve un optional
        return productoJpaRepository.findById(productId).map(producto -> productMapper.toProduct(producto));
    }

    @Override
    public Product save(Product product)
    {
        //convertir un product y guardar un producto
        Producto producto = productMapper.toProducto(product);

        //despues de guardar un producto convertimos a un product
        return productMapper.toProduct(productoJpaRepository.save(producto));
    }

    public void delete(Long idProducto)
    {
        productoJpaRepository.deleteById(idProducto);
    }
}
