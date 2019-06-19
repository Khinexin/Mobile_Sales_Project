package com.demo.mobileproject.sales.service;

import java.util.List;

import com.demo.mobileproject.sales.entity.Product;
import com.demo.mobileproject.exception.ResourceNotFoundException;

public interface ProductService {

    Product createProduct(Product product);

    void updateProduct(Product product);

    List<Product> findAllProduct();

    Product findByIdProduct(int id) throws ResourceNotFoundException;

    void deleteByIdProduct(int id);

    long countProduct();
}
