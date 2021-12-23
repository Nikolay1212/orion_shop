package com.orion.shop.controller;

import com.orion.shop.dto.ProductDto;
import com.orion.shop.model.Category;
import com.orion.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("categories", categoryService.getAllCategories());
        System.out.println(categoryService.getAllCategories());
        return "list";
    }
    @PostMapping("/list")
    public String postList(@ModelAttribute ProductDto productDto) {
        System.out.println(productDto);
        System.out.println(productDto.getId() + " id");
        System.out.println(productDto.getName() + " name");
        System.out.println(productDto.getCategoryId());
        return "list2";
    }
}
