package com.khahnm04.coffee.service;

import com.khahnm04.coffee.entity.Product;
import com.khahnm04.coffee.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void saveProduct(Product product) {
        productRepo.save(product);
    }

    public Product getProductById(String id) {
        return productRepo.findById(id).get();
    }

    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }

}
