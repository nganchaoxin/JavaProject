package com.example.demo.repository;

import com.example.demo.entities.ProductEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Integer> {
    Page<ProductEntity> findByNameContaining(String searchInput, Pageable pageable);

    List<ProductEntity> findAll();
}
