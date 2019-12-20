package com.demo.mobileproject.sales.service;

import java.util.List;

import com.demo.mobileproject.sales.entity.Product;

public interface ProductService {
	
	Product createProduct (Product productInstock);
	Product updateProduct (Product productInstock);
	
	Product findProduct (int id);
	
	void deleteProduct (int id);

	List<Product> findAllProducts();
	
	long countProduct();
	
	void deleteProductInstockByProductId(int productId);
}
