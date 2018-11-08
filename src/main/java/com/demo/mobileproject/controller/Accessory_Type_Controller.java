package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.Accessory_type;
import com.demo.mobileproject.service.Accessory_type_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class Accessory_Type_Controller {
    @Autowired
    private Accessory_type_Service accessory_type_service;

    @GetMapping("/accessoryType")
    public String createAccessory_Type(Model model){
        model.addAttribute("accessory_type",new Accessory_type());
        return "admin/accessoryTypeForm";
    }
    @PostMapping("/accessoryType")
    public String processAccessory_Type(Accessory_type accessory_type){
        accessory_type_service.creAccessoryType(accessory_type);
        return "redirect:/admin/accessoryTypes";
    }
    @GetMapping("/accessoryTypes")
    public String showAllAccessory_Type(Model model){
        model.addAttribute("accessoryType",accessory_type_service.findAllAccessoryTypes());
        return "admin/accessoryTypes";
    }

    @GetMapping("/accessoryTypes/delete/{id}")
    public String deleteAccessory_Type(@PathVariable("id") int id) {
        accessory_type_service.deleteAccessory_type(id);
        return "admin/accessoryTypes";
    }
}