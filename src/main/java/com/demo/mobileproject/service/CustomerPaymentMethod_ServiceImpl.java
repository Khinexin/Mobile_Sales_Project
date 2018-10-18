package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.CustomerPaymentMethod;
import com.demo.mobileproject.repository.CustomerPaymentMethod_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerPaymentMethod_ServiceImpl implements CustomerPaymentMethod_Service {
    @Autowired
    private CustomerPaymentMethod_Repository customerPaymentMethod_repository;
    @Override
    public CustomerPaymentMethod createCustomerPaymentMethod(CustomerPaymentMethod customerPaymentMethod) {
        return customerPaymentMethod_repository.save(customerPaymentMethod);
    }

    @Override
    public List<CustomerPaymentMethod> findAllCustomerPaymentMethods() {
        return customerPaymentMethod_repository.findAll();
    }

    @Override
    public CustomerPaymentMethod findByIdCustomerPaymentMethod(int id) {
        return customerPaymentMethod_repository.findById(id).orElse(null);
    }

    @Override
    public void updateCustomerPaymentMethod(int id) {

        customerPaymentMethod_repository.saveAndFlush(findByIdCustomerPaymentMethod(id));
    }

    @Override
    public void deleteCustomerPaymentMethod(int id) {

        customerPaymentMethod_repository.delete(findByIdCustomerPaymentMethod(id));
    }
}
