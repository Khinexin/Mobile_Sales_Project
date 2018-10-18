package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.CustomerPaymentMethod;
import com.demo.mobileproject.domain.CustomerPaymentVisa;
import com.demo.mobileproject.service.CustomerPaymentMethod_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerPaymentMethod_Controller {
    @Autowired
    private CustomerPaymentMethod_Service customerPaymentMethod_service;

    @GetMapping("/paymentmethod")
    public String createPaymentMethod(Model model){
        model.addAttribute("customerPaymentMethod",new CustomerPaymentMethod());
        return "paymentMethodForm";
    }
    @PostMapping("/paymentmethod")
    public String processPaymentMethod(CustomerPaymentMethod customerPaymentMethod){
        customerPaymentMethod_service.createCustomerPaymentMethod(customerPaymentMethod);
        return "redirect:/paymentMethods";
    }
    @GetMapping("/paymentMethods")
    public String showAllPaymentMethod(Model model){
        model.addAttribute("paymentMethod",customerPaymentMethod_service.findAllCustomerPaymentMethods());
        return "paymentMethods";
    }
}
