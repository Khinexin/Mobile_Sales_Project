package com.demo.mobileproject.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserViewController {

	@GetMapping(value = { "?lang=us", "?lang=mm" })
	public String makeUSUrl(HttpServletRequest request) {
		return request.getServletPath() + "/" + request.getRequestURL();
	}
	
	
}