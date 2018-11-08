package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.LoginCustomer_tbl;
import com.demo.mobileproject.service.LoginCustomer_tbl_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginCustomer_Controller {
    @Autowired
    private LoginCustomer_tbl_Service loginCustomer_tbl_service;

    @GetMapping("/cart/signin_customer")
    public String loginCustomer(Model model, String email, String password) {
        LoginCustomer_tbl loginCustomer_tbl = loginCustomer_tbl_service.loginByEmailAndPassword(email, password);
        model.addAttribute("customer_login", loginCustomer_tbl);
        if (loginCustomer_tbl.getEmail() != email && loginCustomer_tbl.getPassword() != password) {
            return "";
        }
        return "user/loginCustomerForm";
    }

    @GetMapping("/cart/signupcustomer")
    public String createLoginCustomer(Model model){
        model.addAttribute("loginCustomer_tbl",new LoginCustomer_tbl());
        return "user/signupCustomerForm";
    }

    @PostMapping("/signupcustomer")
    public String processLoginCustomer(LoginCustomer_tbl loginCustomer_tbl){
        loginCustomer_tbl_service.createLoginCustomerTbl(loginCustomer_tbl);
        return "redirect:/user/shopping_cart";
    }

    @GetMapping("/admin/customers")
    public String showAllLoginCustomer(Model model){
        model.addAttribute("logincustomer",loginCustomer_tbl_service.findAllLoginCustomerTbls());
        return "admin/customers";
    }
}
