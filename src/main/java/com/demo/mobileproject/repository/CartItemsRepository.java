package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.productcart.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems,Integer> {
}
