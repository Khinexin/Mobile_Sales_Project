package com.demo.mobileproject.controller;

import com.demo.mobileproject.domain.customer.Customer;
import com.demo.mobileproject.service.AppUserService;
import com.demo.mobileproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ForgetPasswordController {

    @Autowired private CustomerService customerService;
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired private AppUserService appUserService;

    @GetMapping("/forgot")
    public String displayForgetPasswordPage(){

        return "forgotPwPage";
    }

    @PostMapping("/forgot")
    public String processingForgetPwPage(ModelAndView model, @RequestParam("email") String email, HttpServletRequest request){

        return "";
    }


    // Display form to reset password
    @GetMapping("/reset")
    public String displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {

        return "resetPassword";
    }

    @PostMapping("/reset") @Transactional
    public String setNewPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        return "";
    }

    // Going to reset page without a token redirects to login page
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
        return new ModelAndView("redirect:/login");
    }


}
