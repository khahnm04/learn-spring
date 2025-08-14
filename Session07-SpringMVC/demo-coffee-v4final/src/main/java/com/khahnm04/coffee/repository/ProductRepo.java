package com.khahnm04.coffee.repository;

import com.khahnm04.coffee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,String> {

}
