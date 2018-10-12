package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.LoginCustomer_tbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginCustomer_tbl_Repository extends JpaRepository<LoginCustomer_tbl,Integer> {
}
