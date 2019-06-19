package com.demo.mobileproject.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {

    @GetMapping(value = {"?lang=us","?lang=fr","?lang=mm","?lang=cn","?lang=jp" })
    public String makeUSUrl(HttpServletRequest request){
        return request.getServletPath()+"/"+request.getRequestURL();
    }

    @GetMapping("/admin/layout")
    public String testAdminLayout(){
        return "admin/layout/adminlayout";
    }
}