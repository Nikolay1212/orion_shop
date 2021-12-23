package com.orion.shop.service;

import com.orion.shop.model.Product;
import com.orion.shop.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public void addProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public void removeProductById(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getAllProductByCategoryId(Long id) {
        return productRepo.getProductByCategory_Id(id);
    }
}
