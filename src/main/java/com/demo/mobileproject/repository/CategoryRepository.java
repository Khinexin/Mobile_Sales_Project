package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.productcart.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
