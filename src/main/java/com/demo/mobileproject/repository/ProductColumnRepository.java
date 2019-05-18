package com.demo.mobileproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.mobileproject.entity.ProductColumn;

@Repository
public interface ProductColumnRepository extends JpaRepository<ProductColumn, Integer> {

}
