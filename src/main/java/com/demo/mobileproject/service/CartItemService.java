package com.demo.mobileproject.service;


import com.demo.mobileproject.domain.productcart.CartItems;

import java.util.List;

public interface CartItemService {
    CartItems createCartItems(CartItems cartItems);
    CartItems findOneByIdCartItems(int id);
    List<CartItems> findAllCartItemst();
    void updateOneCartItems(CartItems cartItems);
    void deleteOneCartItemst(int id);
    void deleteAllCartItems();

}
