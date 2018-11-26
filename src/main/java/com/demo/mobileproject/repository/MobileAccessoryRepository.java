package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.productcart.MobileAccessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileAccessoryRepository extends JpaRepository<MobileAccessory,Integer> {
}
