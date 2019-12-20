package com.demo.mobileproject.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.mobileproject.sales.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	
	@Query("SELECT p FROM Product p JOIN p.category c WHERE c.name  %:category%")
	List<Product> getProductByCategory(@Param("category") String category);
	
	@Query("SELECT p FROM Product p JOIN p.brand b WHERE b.name  %:brand%")
	List<Product> getProductByBrand(@Param("brand") String brand);
	

}
