package com.demo.mobileproject.controller;

import com.demo.mobileproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/proudctList")
    public String findAllProducts(Model model) {
        model.addAttribute("products", productService.findAllProduct());
        return "admin/list_product";
    }

}
