package com.demo.mobileproject.controller;

import com.demo.mobileproject.service.CartItemService;
import com.demo.mobileproject.service.CategoryService;
import com.demo.mobileproject.service.MobileAccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ForUserAddToCartController {

    @Autowired private MobileAccessoryService mobileAccessoryService;
    @Autowired private CategoryService categoryService;
    @Autowired private CartItemService cartItemService;

    @GetMapping("/category/{catid}/productList")
    public String getAllByCatId(@PathVariable("catid") int catId, Model model) {
        model.addAttribute("size",cartItemService.findAllCartItemst().size());
        model.addAttribute("productsByCatId", mobileAccessoryService.findAllMobileAccessoryByCategoryId(catId));
        return "catIdproducts";
    }

    @GetMapping("/category/product/{productId}")
    public String getOneProduct(@PathVariable("productId") int productId, Model model) {
        model.addAttribute("product",mobileAccessoryService.findOneByIdMobileAccessory(productId) );
        return "oneProduct";
    }

    @GetMapping("/home")
    public String userHomePage(Model model){
        model.addAttribute("size",cartItemService.findAllCartItemst().size());
        return "userHome";
    }
}
