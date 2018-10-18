package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.RecordShopExpend;
import com.demo.mobileproject.service.RecordShopExpend_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecordShopExpended_Controller {
    @Autowired
    private RecordShopExpend_Service recordShopExpend_service;
    @GetMapping("/shopexpend")
    public String createRecordShopExpense(Model model){
        model.addAttribute("recordShopExpend",new RecordShopExpend());
        return "expendForm";
    }
    @PostMapping("/shopexpend")
    public String processRecordShopExpense(RecordShopExpend recordShopExpend){
     recordShopExpend_service.createRecordShopExpend(recordShopExpend);
     return "redirect:/expends";
    }
    @GetMapping("/expends")
    public String showAllRecordShopExpense(Model model){
        model.addAttribute("expends",recordShopExpend_service.findAllRecordShopExpends());
        return "expends";
    }
}
