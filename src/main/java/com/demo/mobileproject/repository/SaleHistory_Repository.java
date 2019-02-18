package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.shop.SaleHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleHistory_Repository extends JpaRepository<SaleHistory,Integer> {
}
