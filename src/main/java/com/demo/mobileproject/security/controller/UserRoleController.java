package com.demo.mobileproject.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.mobileproject.security.service.AppRoleService;
import com.demo.mobileproject.security.service.AppUserService;

@Controller
@RequestMapping("/admin")
public class UserRoleController {

	@Autowired
	AppUserService userService;
	@Autowired
	AppRoleService roleService;
	
	// test admin layout
	@GetMapping("/layout")
	public String testAdminLayout() {
		return "admin/layout/adminlayout";
	}
	
	@GetMapping("/createRole")
	public String createRole(Model model) {
		return "admin/create_role";
	}
	
	@PostMapping("/saveRole")
	public String saveRole() {
		return "redirect:/admin/rolelist";
	}
	
	@GetMapping("/editRole/{id}")
	public String updateRole(Model model) {
		return "admin/create_role";
	}
	
	@GetMapping("/deleteRole/{id}")
	public String deleteRole() {
		return "";
	}
	
	@GetMapping("/rolelist")
	public String roleList(Model model) {
		model.addAttribute("roles", roleService.findAllRole());
		return "admin/list_role";
	}
}
