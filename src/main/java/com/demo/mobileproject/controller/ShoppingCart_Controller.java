package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.Shopping_Cart;
import com.demo.mobileproject.service.Shopping_Cart_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShoppingCart_Controller {
    @Autowired
    private Shopping_Cart_Service shopping_cart_service;
    @GetMapping("/shoppingcart")
    public String createShoppingcart(Model model){
        model.addAttribute("shopping_cart",new Shopping_Cart());
        return "cartForm";
    }
    @PostMapping("/shoppingcart")
    public String processSHoppingCart(Shopping_Cart shopping_cart){
        shopping_cart_service.createShoppingCart(shopping_cart);
        return "redirect:/carts";
    }
    @GetMapping("/carts")
    public String showAllCart(Model model){
        model.addAttribute("cart",shopping_cart_service.findAllShoppingCarts());
        return "carts";
    }
}