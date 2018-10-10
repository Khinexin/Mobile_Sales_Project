package com.demo.mobileproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    @GetMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("tagline","Hello Spring MVC!");
        return "welcome";
    }


}
