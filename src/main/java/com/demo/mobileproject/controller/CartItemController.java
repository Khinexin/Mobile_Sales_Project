package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.productcart.CartItems;
import com.demo.mobileproject.domain.productcart.MobileAccessory;
import com.demo.mobileproject.service.CartItemService;
import com.demo.mobileproject.service.MobileAccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class CartItemController {

    @Autowired private CartItemService cartItemService;
    @Autowired private MobileAccessoryService mobileAccessoryService;

    @GetMapping("/cart/add/{itemId}")
    public String addCartItem(@PathVariable("itemId") int id) {

        List<CartItems> cartItemsList = cartItemService.findAllCartItemst();

        MobileAccessory mobileAccessory = mobileAccessoryService.findOneByIdMobileAccessory(id);

        for (int i = 0; i < cartItemsList.size(); i++) {

            CartItems cartItems = cartItemsList.get(i);

            CartItems cartItem=cartItemService.findOneByIdCartItems(cartItems.getItemId());

            if (mobileAccessory.getId() == cartItems.getMobileAccessory().getId()) {
                cartItem.setItemId(cartItems.getItemId());
                cartItem.setQuantity(cartItems.getQuantity() + 1);
                cartItem.setPrice(cartItems.getQuantity() * cartItems.getMobileAccessory().getPrice());
                cartItemService.updateOneCartItems(cartItem);
                break;
            }

        }

        CartItems cartItems = new CartItems();
        cartItems.setMobileAccessory(mobileAccessory);
        cartItems.setQuantity(1);
        cartItems.setPrice(1 * cartItems.getMobileAccessory().getPrice());
        cartItemService.createCartItems(cartItems);

        return "redirect:/home";
    }

    @GetMapping("/cart")
    public String showCartItemPage(Model model){
        model.addAttribute("cartItemList", cartItemService.findAllCartItemst());
        return "cartItems";
    }

    @GetMapping("/cart/remove/{itemId}")
    public String removeCartItem(@PathVariable("itemId") int id) {
        cartItemService.deleteOneCartItemst(id);
        return "redirect:/cart";
    }

    @Transactional
    @GetMapping("/cart/removeAll")
    public String removeAllInCart() {
        cartItemService.deleteAllCartItems();
        return "redirect:/home";
    }

    @GetMapping("/checkout")
    public String checkoutController(){
        return "checkout";
    }
}
