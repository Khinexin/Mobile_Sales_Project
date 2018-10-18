package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.Shopping_Cart;

import java.util.List;

public interface Shopping_Cart_Service {
    Shopping_Cart createShoppingCart(Shopping_Cart shopping_cart);
    List<Shopping_Cart> findAllShoppingCarts();
    Shopping_Cart findByIdShoppingCart(int id);
    void updateShoppingCart(int id);
    void deleteShoppingCart(int id);
}
