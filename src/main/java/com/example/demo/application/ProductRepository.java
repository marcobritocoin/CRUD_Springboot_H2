package com.example.demo.application;
import com.example.demo.domain.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // List<Product> findByName(String name);
    // List<Product> findByPrice(Float price);
    
    List<Product> findByNameContaining(String name);


    
}
