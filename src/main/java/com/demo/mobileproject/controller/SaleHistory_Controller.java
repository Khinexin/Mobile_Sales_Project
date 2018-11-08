package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.SaleHistory;
import com.demo.mobileproject.service.SaleHistory_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class SaleHistory_Controller {
    @Autowired
    private SaleHistory_Service saleHistory_service;
    @GetMapping("/salehistory")
    public String createHistory(Model model){
        model.addAttribute("saleHistory",new SaleHistory());
        return "admin/saleHistoryForm";
    }
    @PostMapping("/salehistory")
    public String processSaleHistory(SaleHistory saleHistory){
        saleHistory_service.createSaleHistory(saleHistory);
        return "redirect:/admin/saleHistories";
    }
    @GetMapping("/saleHistories")
    public String showAllHistory(Model model){
        model.addAttribute("saleHistory",saleHistory_service.findAllSaleHistories());
        return "admin/saleHistories";
    }
}