package com.demo.mobileproject.service;

import java.util.List;

import com.demo.mobileproject.entity.Product;

public interface ProductService {

	Product createProduct(Product productInstock);

	Product updateProduct(Product productInstock);

	Product findProduct(int id);

	void deleteProduct(int id);

	List<Product> findAllProducts();

	long countProduct();

	void deleteProductInstockByProductId(int productId);
	
	long countProductInstockByProductId(int productId);
	
	
	List<Product> findProductsByCategory(String categoryName);
	
	List<Product> findProductsByBrand(String brandName);
}
