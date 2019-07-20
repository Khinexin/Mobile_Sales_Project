package com.demo.mobileproject.sales.repository;

import com.demo.mobileproject.sales.entity.ProductSmartphoneDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSmartphoneDetailsRepository extends JpaRepository<ProductSmartphoneDetails, Integer> {


}
