package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.Authorized_table;
import com.demo.mobileproject.service.Authorized_table_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class Authorized_Table_Controller {
    @Autowired
    private Authorized_table_Service authorized_table_service;
    @GetMapping("/authorize")
    public String createAuthorized_Table(Model model){
        model.addAttribute("authorized_table",new Authorized_table());
        return "admin/authorizedForm";
    }
    @PostMapping("/authorize")
    public String processAuthorized_Table(Authorized_table authorized_table){
        authorized_table_service.createAuthorizedTable(authorized_table);
        return "redirect:/admin/authorization";
    }
    @GetMapping("/authorization")
    public String showAllAuthorized_Table(Model model){
        model.addAttribute("authorizations",authorized_table_service.findAllAuthorizedTables());
        return "admin/authorization";
    }
}
