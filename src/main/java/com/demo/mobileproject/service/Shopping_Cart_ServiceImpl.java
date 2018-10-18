package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.Shopping_Cart;
import com.demo.mobileproject.repository.Shopping_Cart_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Shopping_Cart_ServiceImpl implements Shopping_Cart_Service {
    @Autowired
    private Shopping_Cart_Repository shopping_cart_repository;
    @Override
    public Shopping_Cart createShoppingCart(Shopping_Cart shopping_cart) {
        return shopping_cart_repository.save(shopping_cart);
    }

    @Override
    public List<Shopping_Cart> findAllShoppingCarts() {
        return shopping_cart_repository.findAll();
    }

    @Override
    public Shopping_Cart findByIdShoppingCart(int id) {
        return shopping_cart_repository.findById(id).orElse(null);
    }

    @Override
    public void updateShoppingCart(int id) {
        shopping_cart_repository.saveAndFlush(findByIdShoppingCart(id));

    }

    @Override
    public void deleteShoppingCart(int id) {
        shopping_cart_repository.delete(findByIdShoppingCart(id));

    }
}
