package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.productcart.MobileAccessory;
import com.demo.mobileproject.service.CategoryService;
import com.demo.mobileproject.service.MobileAccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MobileAccessoryController {

    @Autowired private MobileAccessoryService mobileAccessoryService;
    @Autowired private CategoryService categoryService;

    //create
    @GetMapping("/admin/add/product")
    public String createNewProduct(Model model) {
        model.addAttribute("category", categoryService.findAllCategory());
        model.addAttribute("mobileAccessory", new MobileAccessory());
        return "admin/product";
    }

    @PostMapping("/admin/add/product")
    public String processNewProduct(MobileAccessory mobileAccessory) {
        mobileAccessoryService.createMobileAccessory(mobileAccessory);
        return "redirect:/admin/products";
    }

    //edit
    @GetMapping("/admin/edit/product/{id}")
    public String editProduct(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("category", categoryService.findAllCategory());
        model.addAttribute("editmobileAccessory", mobileAccessoryService.findOneByIdMobileAccessory(id));
        return "admin/editproduct";
    }

    @PostMapping("/admin/edit/product")
    public String processEditProduct(@ModelAttribute("editmobileAccessory") MobileAccessory mobileAccessory) {
        mobileAccessoryService.updateOneMobileAccessory(mobileAccessory);
        return "redirect:/admin/products";
    }

    //delete
    @GetMapping("/admin/delete/product/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        mobileAccessoryService.deleteOneCMobileAccessory(id);
        return "redirect:/admin/products";
    }

    //findall
    @GetMapping("/admin/products")
    public String getAllProducts(Model model) {
        model.addAttribute("productList", mobileAccessoryService.findAllMobileAccessory());
        return "admin/products";
    }

    //findByCategoryId
    @GetMapping("/admin/category/{catid}/productList")
    public String getAllByCatId(@PathVariable("catid") int catId, Model model) {
        model.addAttribute("productsByCatId", mobileAccessoryService.findAllMobileAccessoryByCategoryId(catId));
        return "admin/catIdproducts";
    }




    //bro hha and ns
    // please write for following
    // upateby one
    //      mapping ("/admin/product/update/{id})



}
