package com.orion.shop.controller;

import com.orion.shop.global.GlobalData;
import com.orion.shop.model.Product;
import com.orion.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id) {
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String cartGet(Model model) {
        model.addAttribute("cart", GlobalData.cart);
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        return "cart";
    }
}
