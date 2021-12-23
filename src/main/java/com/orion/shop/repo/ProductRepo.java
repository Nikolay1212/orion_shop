package com.orion.shop.repo;

import com.orion.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> getProductByCategory_Id(Long id);
}
