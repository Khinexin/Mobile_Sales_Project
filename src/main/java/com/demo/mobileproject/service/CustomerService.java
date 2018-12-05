package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    Customer findCustomerById(int id);
    Optional<Customer> findCustomerByPhone(String mobile);
    Optional<Customer> findCustomerByEmail(String email);

    Optional<Customer> findAnyCustomerResetToken(String resetToken);

    List<Customer> findAllCustomerList();

    void updateCustomerInformation(Customer customer);

    void deleteCustomerById(int id);
}
