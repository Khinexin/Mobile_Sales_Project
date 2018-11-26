package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.productcart.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCart createShoppingCart(ShoppingCart shoppingCart);
    ShoppingCart findOneByIdShoppingCart(int id);
    List<ShoppingCart> findAllShoppingCart();
    void updateOneShoppingCart(ShoppingCart shoppingCart);
    void deleteOneShoppingCart(int id);

}
