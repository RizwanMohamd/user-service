package com.aja.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
