package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.CustomerPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPaymentMethod_Repository extends JpaRepository<CustomerPaymentMethod,Integer> {
}
