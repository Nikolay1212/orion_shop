package com.orion.shop.service;

import com.orion.shop.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void addProduct(Product product);
    Optional<Product> getProductById(Long id);
    void removeProductById(Long id);
    List<Product> getAllProduct();
    List<Product> getAllProductByCategoryId(Long id);
}
