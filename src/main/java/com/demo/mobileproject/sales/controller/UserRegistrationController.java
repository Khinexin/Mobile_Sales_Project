package com.demo.mobileproject.sales.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.mobileproject.sales.dto.UserRegistrationDto;
import com.demo.mobileproject.security.entity.AppRole;
import com.demo.mobileproject.security.entity.AppUser;
import com.demo.mobileproject.security.service.AppRoleService;
import com.demo.mobileproject.security.service.AppUserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	Logger logger = LogManager.getLogger(UserRegistrationController.class);

	@Autowired
	private AppUserService userService;

	@Autowired
	private AppRoleService roleService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationDto userDto,
			BindingResult result) {

		if (result.hasErrors()) {
			return "registration";
		} else {
			AppUser existing = userService.findUserByEmail(userDto.getEmail());

			if (null != existing) {
				// result.rejectValue("email", null, "{email.already.exit}");

				result.addError(new FieldError("user", "email", userDto.getEmail(), false, null, null,
						"* There is already an account registered with that email!"));
				return "registration";
			} else {

				AppUser user = userDto.toUserEntity();

				String role_user = "ROLE_USER";
//				String role_employee = "ROLE_EMPLOYEE";

				AppRole role = roleService.findRoleByName(role_user);
//				Role roleEmp = roleService.findRoleByName(role_employee);

				if (null == role) {
					role = roleService.createRole(new AppRole(role_user));
				} 

				if (null != role )
					user.setRoles(Arrays.asList(role));

				user.setPassword(passwordEncoder.encode(userDto.getPassword()));
				userService.createUser(user);
				return "redirect:/registration?success";

			}

		}

	}

}
