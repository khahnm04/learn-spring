package com.khahnm04.coffee.repository;

import com.khahnm04.coffee.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Long> {

    // where Name like '%ng%'
    public List<Category> findCategoriesByNameContainingIgnoreCase(String name);

}
