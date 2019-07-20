package com.demo.mobileproject.sales.repository;

import com.demo.mobileproject.sales.entity.ProductInstock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInstockRepository extends JpaRepository<ProductInstock, Integer> {

}
