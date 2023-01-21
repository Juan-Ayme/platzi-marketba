package com.tiendaapip.marketplat.domain.repository;

import com.tiendaapip.marketplat.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository
{
    List<Product> getAll();
    Optional<List<Product>> getByCategory(Long category);
    Optional<List<Product>> getScarseProducts(Long quantity);
    Optional<Product> getProduct(Long productId);
    Product save(Product product);
    void delete(Long productId);
}
