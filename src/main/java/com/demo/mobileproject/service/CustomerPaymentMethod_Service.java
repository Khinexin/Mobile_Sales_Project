package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.CustomerPaymentMethod;

import java.util.List;

public interface CustomerPaymentMethod_Service {
    CustomerPaymentMethod createCustomerPaymentMethod(CustomerPaymentMethod customerPaymentMethod);
    List<CustomerPaymentMethod> findAllCustomerPaymentMethods();
    CustomerPaymentMethod findByIdCustomerPaymentMethod(int id);
    void updateCustomerPaymentMethod(int id);;
    void deleteCustomerPaymentMethod(int id);
}
