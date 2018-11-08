package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.Accessory_tbl;
import com.demo.mobileproject.service.Accessory_tbl_Service;
import com.demo.mobileproject.service.Accessory_type_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class Accessory_tbl_Controller {
    @Autowired
    private Accessory_tbl_Service accessory_tbl_service;

    @Autowired
    private Accessory_type_Service accessory_type_service;

    @GetMapping("/accessory")
    public String createAccessory(Model model){
        model.addAttribute("accessory_types", accessory_type_service.findAllAccessoryTypes());
        model.addAttribute("accessory_tbl",new Accessory_tbl());
        return "admin/accessoryForm";
    }
    @PostMapping("/accessory")
    public String processAccessory_tbl(Accessory_tbl accessory_tbl){
        accessory_tbl_service.createAccessoryTbl(accessory_tbl);
        return "redirect:/admin/accessorys";
    }
    @GetMapping("/accessorys")
    public String showAllAccessory_tbl(Model model){
        model.addAttribute("accessory",accessory_tbl_service.findAllAccessoryTbls());
        return "admin/accessorys";
    }
    @GetMapping("/accessory/delete/{id}")
    public String deleteAccessory_tbl( @PathVariable("id") int id){
        accessory_tbl_service.deleteAccessoryTbl(id);
        return "redirect:/admin/accessorys";
    }
    @GetMapping("/accessory/update/{id}")
    public String updateAccessory_tbl(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("accType",accessory_type_service.findAllAccessoryTypes());

        model.addAttribute("editAccessory",accessory_tbl_service.findByIdAccessoryTbl(id));
        return "admin/editAccessory";
    }
    @PostMapping("/accessory/update")
    public String updateProccessAccessory_tbl(@ModelAttribute("editAccessory")Accessory_tbl accessory_tbl,ModelMap model){
        accessory_tbl_service.updateAccessoryTbl(accessory_tbl);
        return "redirect:/admin/accessorys";
    }
}
