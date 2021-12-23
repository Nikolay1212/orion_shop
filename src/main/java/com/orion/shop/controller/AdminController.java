package com.orion.shop.controller;

import com.orion.shop.dto.AccountDto;
import com.orion.shop.dto.ProductDto;
import com.orion.shop.form.SignUpForm;
import com.orion.shop.model.Account;
import com.orion.shop.model.Category;
import com.orion.shop.model.Product;
import com.orion.shop.model.Role;
import com.orion.shop.service.AccountService;
import com.orion.shop.service.CategoryService;
import com.orion.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable Long id) {
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable Long id, Model model) {
        Optional<Category> optionalCategory = categoryService.getCategoryById(id);
        if (optionalCategory.isPresent()) {
            model.addAttribute("category", optionalCategory.get());
            return "categoriesAdd";
        } else {
            return "404";
        }
    }

    //Product

    @GetMapping("admin/products")
    public String products(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "products";
    }
    @GetMapping("/admin/products/add")
    public String productAddGet(Model model) {
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "productsAdd";
    }
    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDto") ProductDto productDto) {
        System.out.println(productDto + " &&&&&");
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageName(productDto.getImageName());
        product.setCategory(categoryService.getCategoryById(productDto.getCategoryId()).get());
        productService.addProduct(product);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/product/update/{id}")
    public String deleteProduct(@PathVariable long id, Model model) {
        Product product = productService.getProductById(id).get();
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("productDto", productDto);
        return "redirect:/admin/products";
    }

    //USERS

    @GetMapping("/admin/users")
    public String getUsers(Model model) {
        model.addAttribute("accounts", accountService.getUsers());
        return "users";
    }
    @PostMapping("admin/users/add")
    public String addUser(@RequestBody SignUpForm form) {
        Account account = new Account();
        account.setEmail(form.getEmail());
        account.setFirstName(form.getFirstName());
        account.setRole(Role.USER);
        return "redirect:/admin/users";
    }
}
