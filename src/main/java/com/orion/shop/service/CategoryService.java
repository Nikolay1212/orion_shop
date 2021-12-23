package com.orion.shop.service;

import com.orion.shop.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void addCategory(Category category);
    Optional<Category> getCategoryById(Long id);
    List<Category> getAllCategories();
    void removeCategoryById(Long id);
}
