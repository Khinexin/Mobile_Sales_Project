package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.Mobile_tbl;
import com.demo.mobileproject.service.Mobile_Tbl_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Mobile_tbl_Controller {

    @Autowired
    private Mobile_Tbl_Service mobile_tbl_service;

    @GetMapping("/mobile")
    public String createMobile_tbl(Model  model){
        model.addAttribute("mobile_tbl",new Mobile_tbl());
        return "admin/mobileForm";
    }
    @PostMapping("/mobile")
    public String processMobileTbl(Mobile_tbl mobile_tbl){
        mobile_tbl_service.createMobileTbl(mobile_tbl);
        return "redirect:/admin/mobiles";
    }
    @GetMapping("/mobiles")
    public String showAllMobileTbl(Model model){
        model.addAttribute("mobile",mobile_tbl_service.findAllMobileTbls());
        return "admin/mobiles";
    }
}
