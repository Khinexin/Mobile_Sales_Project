package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.LoginCustomer_tbl;
import com.demo.mobileproject.service.LoginCustomer_tbl_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginCustomer_Controller {
    @Autowired
    private LoginCustomer_tbl_Service loginCustomer_tbl_service;
    @GetMapping("/logincustomer")
    public String createLoginCustomer(Model model){
        model.addAttribute("loginCustomer_tbl",new LoginCustomer_tbl());
        return "loginCustomerForm";
    }
    @PostMapping("/logincustomer")
    public String processLoginCustomer(LoginCustomer_tbl loginCustomer_tbl){
        loginCustomer_tbl_service.createLoginCustomerTbl(loginCustomer_tbl);
        return "redirect:/logincustomers";
    }
    @GetMapping("/logincustomers")
    public String showAllLoginCustomer(Model model){
        model.addAttribute("logincustomer",loginCustomer_tbl_service.findAllLoginCustomerTbls());
        return "logincustomers";
    }
}
