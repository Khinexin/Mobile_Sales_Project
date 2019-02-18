package com.demo.mobileproject.service.Impl;

import com.demo.mobileproject.domain.productcart.ShoppingCart;
import com.demo.mobileproject.repository.ShoppingCartRepository;
import com.demo.mobileproject.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart findOneByIdShoppingCart(int id) {
        return shoppingCartRepository.getOne(id);
    }

    @Override
    public List<ShoppingCart> findAllShoppingCart() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public void updateOneShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.saveAndFlush(shoppingCart);
    }

    @Override
    public void deleteOneShoppingCart(int id) {
        shoppingCartRepository.deleteById(id);
    }
}
