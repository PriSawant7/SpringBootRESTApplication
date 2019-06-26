package com.springbootrestapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrestapplication.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}