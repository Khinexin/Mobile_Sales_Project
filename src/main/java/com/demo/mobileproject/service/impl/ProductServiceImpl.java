package com.demo.mobileproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mobileproject.entity.Product;
import com.demo.mobileproject.exception.ResourceNotFoundException;
import com.demo.mobileproject.repository.ProductRepository;
import com.demo.mobileproject.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findByIdProduct(int id) throws ResourceNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public void deleteByIdProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public long countProduct() {
        return productRepository.count();
    }


}
