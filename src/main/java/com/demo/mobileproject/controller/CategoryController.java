package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.productcart.Category;
import com.demo.mobileproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired private CategoryService categoryService;

    @GetMapping("/admin/add/category")
    public String createCategory(Model model) {
        model.addAttribute("category", new Category());
        return "admin/category";
    }

    @PostMapping("/admin/add/category")
    public String createProcessCategory(Category category) {
        categoryService.createCategory(category);
        return "redirect:/admin/category/list";
    }

    @GetMapping("/admin/category/list")
    public String findAllCategory(Model model) {
        model.addAttribute("categoryList", categoryService.findAllCategory());
        return "admin/categoryList";
    }

    //bro hha and ns
    // please write for following
    // retrieve one
    //      mapping ("/admin/category/{id})
    //      return "admin/oneCategory"
    // delete one
    //      mapping ("/admin/category/delete/{id})



}
