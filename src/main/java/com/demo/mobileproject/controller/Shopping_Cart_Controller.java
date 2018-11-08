package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.Accessory_tbl;
import com.demo.mobileproject.domain.Mobile_tbl;
import com.demo.mobileproject.domain.Shopping_Cart;
import com.demo.mobileproject.service.Accessory_tbl_Service;
import com.demo.mobileproject.service.Mobile_Tbl_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class Shopping_Cart_Controller {


    @Autowired
    private Accessory_tbl_Service accessory_tbl_service;
    @Autowired
    private Mobile_Tbl_Service mobile_tbl_service;

    @Autowired
    private Shopping_Cart shopping_cart;

    private double sum = 0;


    // list in cart
    @GetMapping("/cart")
    public String showCard(Model model) {

        List<Accessory_tbl> accessory_tbls = shopping_cart.getAccessory_tblList();
        List<Mobile_tbl> mobile_tbls = shopping_cart.getMobile_tblList();
        double accessorytotalprice = 0;
        double mobiletotalprice = 0;

        model.addAttribute("cartAccessories", accessory_tbls);
        model.addAttribute("cartMobiles", mobile_tbls);


        for (Accessory_tbl accessory_tbl : accessory_tbls) {
            accessorytotalprice += accessory_tbl.getPrice_per_item();
            shopping_cart.setAccessoryquantity(shopping_cart.getAccessoryquantity() + 1);
        }
        for (Mobile_tbl mobile_tbl : mobile_tbls) {
            mobiletotalprice += mobile_tbl.getPrice();
            shopping_cart.setMobilequantity(shopping_cart.getMobilequantity() + 1);
        }
        sum = accessorytotalprice + mobiletotalprice;


        model.addAttribute("total", sum);

        return "user/shopping_cart";
    }

    //remove all
    @GetMapping("/cart/removall")
    public String clearCart() {
        shopping_cart.removeAll();
        return "redirect:/cart";
    }


    //checkout (confirm to buy or not)
    @GetMapping("/cart/checkout")
    public String checkOut(Model model) {

        List<Accessory_tbl> accessory_tbls = shopping_cart.getAccessory_tblList();
        List<Mobile_tbl> mobile_tbls = shopping_cart.getMobile_tblList();

        for (Accessory_tbl accessory_tbl : accessory_tbls) {
            sum += accessory_tbl.getPrice_per_item();
        }
        for (Mobile_tbl mobile_tbl : mobile_tbls) {
            sum += mobile_tbl.getPrice();
        }
        model.addAttribute("cartAccessory", accessory_tbls);
        model.addAttribute("cartMobile", mobile_tbls);
        model.addAttribute("total", sum);
        return "user/checkouts";
    }

    @GetMapping("/cart/update/{id}")
    public String updateShoppingCartQuantity(@PathVariable("id") int id) {

        return "";
    }

    ///////////////////  buttons  ///////////////////

    //Add accessory to cart
    @GetMapping("/cart/accessory/{accessory_id}")
    public String addAccessoryToCard(@PathVariable("accessory_id") int id) {
        Accessory_tbl accessory_tbl = accessory_tbl_service.findByIdAccessoryTbl(id);
        shopping_cart.addAccessoryToCart(accessory_tbl);
        return "redirect:/accessory";
    }

    //Add mobile to cart
    @GetMapping("/cart/mobile/{mobile_id}")
    public String addMobileToCard(@PathVariable("mobile_id") int id, Model model) {
        Mobile_tbl mobile = mobile_tbl_service.findByIdMobileTbl(id);
        shopping_cart.addMobileToCart(mobile);
        return "redirect:/mobile";
    }


    ///////////////////  home pages  ///////////////////
// for home page
    @GetMapping("/")
    public String homepage() {
        return "user/homepage";
    }

    //mobile home
    @GetMapping("/mobile")
    public String showAllMobiles(Model model) {
        model.addAttribute("mobiles", mobile_tbl_service.findAllMobileTbls());
        model.addAttribute("size", shopping_cart.getAccessory_tblList().size());
        return "user/u_mobile";
    }

    //accessory home
    @GetMapping("/accessory")
    public String showAllAccessory(Model model) {
        model.addAttribute("accessories", accessory_tbl_service.findAccessoryByInstockQuantity());
        model.addAttribute("size", shopping_cart.getMobile_tblList().size());
        return "user/u_accessory";
    }

}
