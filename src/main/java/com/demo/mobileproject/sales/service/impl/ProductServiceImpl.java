package com.demo.mobileproject.sales.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mobileproject.sales.entity.Product;
import com.demo.mobileproject.sales.entity.ProductInstock;
import com.demo.mobileproject.sales.repository.ProductInstockRepository;
import com.demo.mobileproject.sales.repository.ProductRepository;
import com.demo.mobileproject.sales.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository ProductRepository;

	@Autowired
	ProductInstockRepository productInstockRepository;

	@Override
	public Product createProduct(Product productInstock) {
		return ProductRepository.save(productInstock);
	}

	@Override
	public Product updateProduct(Product productInstock) {
		return ProductRepository.saveAndFlush(productInstock);
	}

	@Override
	public Product findProduct(int id) {
		return ProductRepository.getOne(id);
	}

	@Override
	public void deleteProduct(int id) {
		ProductRepository.deleteById(id);
	}

	@Override
	public List<Product> findAllProducts() {
		return ProductRepository.findAll();
	}

	@Override
	public long countProduct() {
		return ProductRepository.count();
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

//	private List<ProductInstock> searchListAndSetProductNull(int productId) {
//		List<ProductInstock> pIns = productInstockRepository.selectProductInsotckByProductId(productId);
//		for (ProductInstock pin : pIns) {
//			pin.setProduct(null);
//			System.out.println(" to delete list");
//			System.out.print(":: id \t"+pin.getId());
//			
//		}
//		return pIns;
//	}

	
}
