package com.demo.mobileproject.service.Impl;

import com.demo.mobileproject.domain.customer.Customer;
import com.demo.mobileproject.repository.CustomerRepository;
import com.demo.mobileproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerRepository.getOne(id);
    }

    @Override
    public Customer findCustomerByPhone(String mobile) {
        return customerRepository.findCustomerByPhone(mobile);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    @Override
    public List<Customer> findAllCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public void updateCustomerInformation(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }
}