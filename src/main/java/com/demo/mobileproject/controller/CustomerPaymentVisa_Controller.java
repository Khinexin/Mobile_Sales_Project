package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.CustomerPaymentVisa;
import com.demo.mobileproject.service.CustomerPaymentVisa_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class CustomerPaymentVisa_Controller {
    @Autowired
    private CustomerPaymentVisa_Service customerPaymentVisa_service;
    @GetMapping("/paymentvisa")
    public String createCustomerPaymentVisa(Model model){
        model.addAttribute("customerPaymentVisa",new CustomerPaymentVisa());
        return "admin/paymentvisaForm";
    }
    @PostMapping("/paymentvisa")
    public String processCustomerPaymentVisa(CustomerPaymentVisa customerPaymentVisa){
        customerPaymentVisa_service.createCustomerPaymentVisa(customerPaymentVisa);
        return "redirect:/admin/paymentvisas";
    }
    @GetMapping("/paymentvisas")
    public String showAllCustomerPaymentVisa(Model model){
        model.addAttribute("paymentvisa",customerPaymentVisa_service.findAllCustomerPaymentVisas());
        return "admin/paymentvisas";
    }
}
