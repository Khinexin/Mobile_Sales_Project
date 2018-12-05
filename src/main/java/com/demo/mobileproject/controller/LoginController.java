package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.customer.Customer;
import com.demo.mobileproject.domain.login.AppUser;
import com.demo.mobileproject.domain.login.UserRole;
import com.demo.mobileproject.domain.login.WebUtils;
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

    @GetMapping(value = { "/", "/welcome" })
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

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
        model.addAttribute("customer", new Customer());
        return "register";
    }
    @PostMapping("/register")
    public String processingCustomer(@Valid Customer customer, Model model, BindingResult bindingResult){
        Optional<Customer> customerEmailAlreadyExit = customerService.findCustomerByEmail(customer.getEmailAddress());
        if (customerEmailAlreadyExit.isPresent()) {
            bindingResult
                    .rejectValue("email", "error.customer",
                            "There is already a user registered with the email provided");
        }
        if(bindingResult.hasErrors()){
            return "register";
        }
        customerService.createCustomer(customer);
        customerIdForNext =customer.getCustomerId();
        return "redirect:/register/nextUser";
    }
    @GetMapping("/register/nextUser")
    public String registerNextPageToNewAppUserAcc(Model model){
        model.addAttribute("appUser", new AppUser());
        return "newUser";
    }
    @PostMapping("/register/nextUser") @Transactional
    public String processingUser(@Valid AppUser appUser, BindingResult bindingResult){
        AppUser appUserAlreadyExitOrNot = appUserService.findAppUserByName(appUser.getUserName());
        if(appUserAlreadyExitOrNot != null){
            bindingResult.rejectValue("username", "error.username",
                    "There is already used username. please provice other");
        }
        if(bindingResult.hasErrors()){
            return "newUser";
        }
        appUser.setUserId(customerIdForNext);
        appUser.setEnabled(true);
        Customer customer =customerService.findCustomerById(customerIdForNext);

        appUser.setEncrytedPassword(passwordEncoder.encode(appUser.getEncrytedPassword()));
        customer.setAppUser(appUserService.createAppUser(appUser));

        // this is for user   role
        customUserRoleService.addNewUserAndRole(
                UserRole.builder()
                        .id(appUser.getUserId())
                        .appRole(appRoleService.findAppRoleById(2))
                        .appUser(appUser)
                        .build());

        System.out.println("CustomerId: " + customerIdForNext);
        System.out.println("UserId: "+appUser.getUserId());
        System.out.println("AppRoleId:"+ customerIdForNext);

        return "redirect:/register/successRegister";
    }
    @GetMapping("/register/successRegister")
    public String successRegisterPage(){
        return "successRegister";
    }

    //// Shipping Address
    //// Billing Address Address
    //// ShoppingCart Address Address

}
