package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.customer.Customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    Customer findCustomerById(int id);
    Customer findCustomerByPhone(String mobile);
    Customer findCustomerByEmail(String email);

    List<Customer> findAllCustomerList();

    void updateCustomerInformation(Customer customer);

    void deleteCustomerById(int id);
}
