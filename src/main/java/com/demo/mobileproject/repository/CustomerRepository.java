package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.emailAddress=:email")
    Customer findCustomerByEmail(@Param("email") String email);

    @Query("SELECT c FROM Customer c WHERE c.customerPhone=:mobile")
    Customer findCustomerByPhone(@Param("mobile") String mobile);
}
