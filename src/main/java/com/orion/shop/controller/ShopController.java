package com.orion.shop.controller;

import com.orion.shop.global.GlobalData;
import com.orion.shop.service.CategoryService;
import com.orion.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShopController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping({"/", "/home", "/shop"})
    public String home(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable Long id) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("products", productService.getAllProductByCategoryId(id));
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/viewProduct/{productId}")
    public String viewProduct(Model model, @PathVariable Long productId) {
        model.addAttribute("product", productService.getProductById(productId).get());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "viewProduct";
    }

    @GetMapping("/shop/addToCart/{productId}")
    public String addToCart(@PathVariable Long productId) {
        GlobalData.cart.add(productService.getProductById(productId).get());
        return "redirect:/shop";
    }
}
