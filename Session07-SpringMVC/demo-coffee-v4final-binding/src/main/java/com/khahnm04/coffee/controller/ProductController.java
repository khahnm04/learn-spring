package com.khahnm04.coffee.controller;

import com.khahnm04.coffee.entity.Product;
import com.khahnm04.coffee.service.CategoryService;
import com.khahnm04.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public String showList(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/products/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("selectedOne", productService.getProductById(id));
        model.addAttribute("cates", categoryService.getAllCategories());
        return "product-form";
    }

    @GetMapping("/products/new")
    public String create(Model model) {
        model.addAttribute("selectedOne", new Product());
        model.addAttribute("cates", categoryService.getAllCategories());
        return "product-form";
    }

    // save
    @PostMapping("/products/save")
    public String save(@ModelAttribute("selectedOne") Product prod) {
        productService.saveProduct(prod);
        return "redirect:/products";
    }

    // delete
    @GetMapping("/products/delete/{id}")
    public String delete(@PathVariable String id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

}
