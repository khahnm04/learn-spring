package com.khahnm04.coffee.config;

import com.khahnm04.coffee.entity.Category;
import com.khahnm04.coffee.entity.Product;
import com.khahnm04.coffee.service.CategoryService;
import com.khahnm04.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category("Trà sữa", "Uống trà sữa");
        Category cat2 = new Category("Cà phê", "Uống Cà phê Java");
        Category cat3 = new Category("Beer-tăng lực", "Uống Beer-tăng lực");
        Category cat4 = new Category("Bánh kẹo", "Ăn bánh kẹo");

        Product p1c1 = new Product("TS01", "Trà Sữa Hàng Xóm", 79, 39_000);
        Product p2c1 = new Product("TS02", "Trà Sữa Nhà Làm", 79, 68_000);
        cat1.addProduct(p1c1);
        cat1.addProduct(p2c1);

        Product p1c2 = new Product("CF01", "Cafe Nguyên Bản Vị Java", 35, 57_000);
        Product p2c2 = new Product("CF02", "Cafe Nguyên Bản Nhà Làm", 35, 23_500);
        Product p3c2 = new Product("CF03", "Cafe Nguyên Bản Đậm Đà", 6789, 52_000);
        cat2.addProduct(p1c2);
        cat2.addProduct(p2c2);
        cat2.addProduct(p3c2);

        categoryService.saveCategory(cat1);
        categoryService.saveCategory(cat2);
        categoryService.saveCategory(cat3);
        categoryService.saveCategory(cat4);

    }

}
