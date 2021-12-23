package com.orion.shop.service;

import com.orion.shop.model.Category;
import com.orion.shop.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public void removeCategoryById(Long id) {
        categoryRepo.deleteById(id);
    }
}
