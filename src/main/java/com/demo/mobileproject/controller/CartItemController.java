package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.productcart.CartItems;
import com.demo.mobileproject.domain.productcart.MobileAccessory;
import com.demo.mobileproject.service.CartItemService;
import com.demo.mobileproject.service.MobileAccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class CartItemController {

    @Autowired private CartItemService cartItemService;
    @Autowired private MobileAccessoryService mobileAccessoryService;

    @GetMapping("/cart/add/{itemId}")
    public void addCartItem(@PathVariable("itemId") int id) {

        List<CartItems> cartItemsList = cartItemService.findAllCartItemst();

        MobileAccessory mobileAccessory = mobileAccessoryService.findOneByIdMobileAccessory(id);

        for (int i = 0; i < cartItemsList.size(); i++) {
            CartItems cartItems = cartItemsList.get(i);
            if (mobileAccessory.getId() == cartItems.getMobileAccessory().getId()) {
                cartItems.setQuantity(cartItems.getQuantity() + 1);
                cartItems.setPrice(cartItems.getQuantity() * cartItems.getMobileAccessory().getPrice());
                cartItemService.createCartItems(cartItems);
            }
        }

        CartItems cartItems = new CartItems();
        cartItems.setMobileAccessory(mobileAccessory);
        cartItems.setQuantity(1);
        cartItems.setPrice(1 * cartItems.getMobileAccessory().getPrice());
        cartItemService.createCartItems(cartItems);
        return;
    }

    @GetMapping("/cart/remove/{itemId}")
    public void removeCartItem(@PathVariable("itemId") int id) {
        cartItemService.deleteOneCartItemst(id);
        return;
    }

    @Transactional
    @GetMapping("/cart/removeAll/{cartId}")
    public void removeAllInCart(@PathVariable("cartId") int cartId) {
        cartItemService.deleteAllCartItems();
        return;
    }
}
