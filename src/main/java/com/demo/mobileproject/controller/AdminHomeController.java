package com.demo.mobileproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeController {

    @GetMapping("/admin/layout")
    public String checkAdminLayout(){
        return "layout/adminLayout";
    }
    @GetMapping("/admin/home")
    public String checkAdminHomePage(){
        return "admin/index";
    }
}
