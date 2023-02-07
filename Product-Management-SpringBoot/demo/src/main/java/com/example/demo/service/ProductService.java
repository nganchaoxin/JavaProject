package com.example.demo.service;

import com.example.demo.repository.ProductRepository;
import com.example.demo.entities.ProductEntity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<ProductEntity> getProducts() {
        return (List<ProductEntity>) productRepository.findAll();
    }
}
