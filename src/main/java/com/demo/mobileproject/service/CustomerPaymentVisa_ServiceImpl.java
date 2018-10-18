package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.CustomerPaymentVisa;
import com.demo.mobileproject.repository.CustomerPaymentVisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerPaymentVisa_ServiceImpl implements CustomerPaymentVisa_Service {
    @Autowired
    private CustomerPaymentVisaRepository customerPaymentVisaRepository;
    @Override
    public CustomerPaymentVisa createCustomerPaymentVisa(CustomerPaymentVisa customerPaymentVisa) {
        return customerPaymentVisaRepository.save(customerPaymentVisa);
    }

    @Override
    public List<CustomerPaymentVisa> findAllCustomerPaymentVisas() {
        return customerPaymentVisaRepository.findAll();
    }

    @Override
    public CustomerPaymentVisa findByIdCustomerPaymentVisa(int id) {
        return customerPaymentVisaRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCustomerPaymentVisa(int id) {
        customerPaymentVisaRepository.saveAndFlush(findByIdCustomerPaymentVisa(id));
    }

    @Override
    public void deleteCustomerPaymentVisa(int id) {
        customerPaymentVisaRepository.delete(findByIdCustomerPaymentVisa(id));
    }
}
