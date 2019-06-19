package com.demo.mobileproject.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.mobileproject.sales.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
