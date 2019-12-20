package com.demo.mobileproject.sales.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mobileproject.sales.entity.Product;
import com.demo.mobileproject.sales.repository.ProductInstockRepository;
import com.demo.mobileproject.sales.repository.ProductRepository;
import com.demo.mobileproject.sales.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductInstockRepository productInstockRepository;

	@Override
	public Product createProduct(Product productInstock) {
		return productRepository.save(productInstock);
	}

	@Override
	public Product updateProduct(Product productInstock) {
		return productRepository.saveAndFlush(productInstock);
	}

	@Override
	public Product findProduct(int id) {
		return productRepository.getOne(id);
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public long countProduct() {
		return productRepository.count();
	}

	@Override
	@Transactional
	public void deleteProductInstockByProductId(int productId) {
		productInstockRepository.deleteProductInstockById(productId);
	}

	@Override
	public long countProductInstockByProductId(int productId) {
		return productInstockRepository.countProductInsotckByProductId(productId);
	}

	@Override
	public List<Product> findProductsByCategory(String categoryName) {
		return productRepository.getProductByCategory(categoryName);
	}

	@Override
	public List<Product> findProductsByBrand(String brandName) {
		return productRepository.getProductByBrand(brandName);
	}


	
	
}
