package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.Shopping_Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Shopping_Cart_Repository extends JpaRepository<Shopping_Cart,Integer> {
}
