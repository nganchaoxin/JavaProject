package com.example.demo.service;

import com.example.demo.repository.ProductRepository;
import com.example.demo.entities.ProductEntity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Page<ProductEntity> getProductsByName(String searchInput, Pageable pageable) {
        return productRepository.findByNameContaining(searchInput,pageable);
    }
    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }
}
