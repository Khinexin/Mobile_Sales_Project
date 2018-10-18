package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.CustomerPaymentVisa;

import java.util.List;

public interface CustomerPaymentVisa_Service {
    CustomerPaymentVisa createCustomerPaymentVisa(CustomerPaymentVisa customerPaymentVisa);
    List<CustomerPaymentVisa> findAllCustomerPaymentVisas();
    CustomerPaymentVisa findByIdCustomerPaymentVisa(int id);
    void updateCustomerPaymentVisa(int id);
    void deleteCustomerPaymentVisa(int id);
}
