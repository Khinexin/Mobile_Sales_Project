package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.customer.BIllingAddress;
import com.demo.mobileproject.domain.customer.Customer;
import com.demo.mobileproject.domain.customer.DeliveryAddress;
import com.demo.mobileproject.domain.login.AppUser;
import com.demo.mobileproject.domain.login.UserRole;
import com.demo.mobileproject.domain.login.WebUtils;
import com.demo.mobileproject.domain.productcart.ShoppingCart;
import com.demo.mobileproject.service.AppRoleService;
import com.demo.mobileproject.service.AppUserService;
import com.demo.mobileproject.service.CustomerService;
import com.demo.mobileproject.service.CustomUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired private CustomerService customerService;
    @Autowired private AppUserService appUserService;
    @Autowired private AppRoleService appRoleService;
    @Autowired private CustomUserRoleService customUserRoleService;
    @Autowired private BCryptPasswordEncoder passwordEncoder;

    private int customerIdForNext;



    @GetMapping(value = "/admin")
    public String adminPage(Model model, Principal principal) {
        model.addAttribute("userInfo", WebUtils.toString((User) ((Authentication) principal).getPrincipal()));
        return "adminPage";
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model) {
        return "loginPage";
    }

    @GetMapping(value = "/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @GetMapping(value = "/userInfo")
    public String userInfo(Model model, Principal principal) {

        // After user login successfully.
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            model.addAttribute("userInfo", WebUtils.toString((User) ((Authentication) principal).getPrincipal()));
            model.addAttribute("message", "Hi " + principal.getName() + "<br> You do not have permission to access this page!");
        }
        return "403Page";
    }

//    registeration

    @GetMapping("/register")
    public String registerAsNewCustomer(Model model){
        model.addAttribute("appUser", new AppUser());
        return "register";
    }
    @PostMapping("/register") @Transactional
    public String processingCustomer(@Valid AppUser appUser, Model model, BindingResult bindingResult){

        Optional<AppUser> customerEmailAlreadyExit = appUserService.findAppUserByEmailAddress(appUser.getEmailAddress());

        if (customerEmailAlreadyExit.isPresent()) {
            bindingResult
                    .rejectValue("email", "error.appUser",
                            "There is already a user registered with the email provided");
        }
        AppUser appUserAlreadyExitOrNot = appUserService.findAppUserByName(appUser.getUserName());
        if(appUserAlreadyExitOrNot != null){
            bindingResult.rejectValue("username", "error.username",
                    "There is already used username. please provice other");
        }
        if(bindingResult.hasErrors()){
            return "register";
        }

        appUser.setEnabled(true);
        appUser.setEncrytedPassword(passwordEncoder.encode(appUser.getEncrytedPassword()));

        appUserService.createAppUser(appUser);

        customerIdForNext =appUser.getUserId();

        // this is for user   role
        customUserRoleService.addNewUserAndRole(
                UserRole.builder()
                        .id(appUser.getUserId())
                        .appRole(appRoleService.findAppRoleById(2))
                        .appUser(appUser)
                        .build());

        Customer.builder()
                .customerId(customerIdForNext)
                .appUser(appUserService.findAppUserById(customerIdForNext))
                .bIllingAddress(BIllingAddress.builder().billinId(customerIdForNext).build())
                .deliveryAddress(DeliveryAddress.builder().shippingId(customerIdForNext).build())
                .shoppingCart(ShoppingCart.builder().shoppingCartId(customerIdForNext).build())
                .build();


        return "redirect:/login";
    }

    @GetMapping("/register/nextUser")
    public String registerNextPageToNewAppUserAcc(Model model){
        model.addAttribute("customer", new Customer());
        return "newUser";
    }
    @PostMapping("/register/nextUser")
    @Transactional
    public String processingUser(@Valid Customer customer, BindingResult bindingResult, Model model){

        Customer customer1 = customerService.findCustomerById(customerIdForNext);

        customer1.setDeliveryAddress(customer.getDeliveryAddress());
        customer1.setBIllingAddress(customer.getBIllingAddress());

        //// Shipping Address
        //// Billing Address Address

        System.out.println( "var: " + customerIdForNext +"\n"+
                "CustomerId: " + customer1.getCustomerId() +"\n"+
                "UserId: "+customer1.getAppUser().getUserId() +"\n"+
                "AppRoleId:"+ appRoleService.findAppRoleNameByUserId(customer1.getAppUser().getUserId()));



        return "redirect:/register/successRegister";
    }

    @GetMapping("/register/successRegister")
    public String successRegisterPage(){
        return "successRegister";
    }



}
