package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.CustomerPaymentVisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPaymentVisaRepository extends JpaRepository<CustomerPaymentVisa,Integer> {
}
