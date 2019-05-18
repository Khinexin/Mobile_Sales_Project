package com.demo.mobileproject.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.mobileproject.entity.Category;
import com.demo.mobileproject.exception.ResourceNotFoundException;
import com.demo.mobileproject.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    private boolean isCreate;


    // create
    @GetMapping("/createCategory")
    public String createCategory(ModelMap model) {
        isCreate = true;
        model.addAttribute("isCreate", isCreate);
        model.addAttribute("category", Category.builder().id(-1).build());
        return "admin/create_category";
    }

    @PostMapping("/saveCategory")
    public String createProcessCategory(@ModelAttribute("category") @Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/create_category";
        }
        if (isCreate == true) {
            categoryService.createCategory(category);
        } else if (category.getId() > 0 || isCreate == false) {
            categoryService.updateCategory(category);
        }
        return "redirect:/admin/categorylist";
    }

    //update
    @GetMapping("/editCategory/{id}")
    public String editCategoryById(@PathVariable("id") int id, ModelMap model) {
        try {
            model.addAttribute("category", categoryService.findByIdCategory(id));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        isCreate = false;
        model.addAttribute("isCreate", isCreate);
        return "admin/create_category";
    }

    //findall
    @GetMapping("/categorylist")
    public String findAllCategoryList(Model model) {
        model.addAttribute("categoryList", categoryService.findAllCategory());
        return "admin/list_category";
    }

    //delete
    @GetMapping("/deleteCategory/{id}")
    public String deleteCategoryById(@PathParam("id") int id) {
        categoryService.deleteByIdCategory(id);
        return "redirect:/admin/categorylist";
    }
}
