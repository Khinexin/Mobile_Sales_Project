package com.demo.mobileproject.service.Impl;

import com.demo.mobileproject.domain.productcart.CartItems;
import com.demo.mobileproject.repository.CartItemsRepository;
import com.demo.mobileproject.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired CartItemsRepository cartItemsRepository;

    @Override
    public CartItems createCartItems(CartItems cartItems) {
        return cartItemsRepository.save(cartItems);
    }

    @Override
    public CartItems findOneByIdCartItems(int id) {
        return cartItemsRepository.getOne(id);
    }

    @Override
    public List<CartItems> findAllCartItemst() {
        return cartItemsRepository.findAll();
    }

    @Override
    public void updateOneCartItems(CartItems cartItems) {
        cartItemsRepository.saveAndFlush(cartItems);
    }

    @Override
    public void deleteOneCartItemst(int id) {
        cartItemsRepository.deleteById(id);
    }

    @Override
    public void deleteAllCartItems() {
        cartItemsRepository.deleteAll();
    }
}
