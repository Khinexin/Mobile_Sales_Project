package com.demo.mobileproject.sales.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

import com.demo.mobileproject.security.config.FieldMatch;
import com.demo.mobileproject.security.entity.AppUser;

@FieldMatch.List({ @FieldMatch(first = "password", second = "confirmPassword", message = "{match.pw}"),
		@FieldMatch(first = "email", second = "confirmEmail", message = "{match.email}") })
@Getter
@Setter
public class UserRegistrationDto {

	private Integer id;

	@NotEmpty(message = "{name.empty}")
	private String name;

	@NotEmpty(message = "{password.empty}")
	private String password;

	@NotEmpty(message = "{confirmpw.empty}")
	private String confirmPassword;

	@Email(message = "{email.invalid}")
	@NotEmpty(message = "{email.empty}")
	private String email;

	@Email(message = "{email.invalid}")
	@NotEmpty(message = "{confirmemail.empty}")
	private String confirmEmail;

	@AssertTrue(message = "{terms.true}")
	private Boolean terms;

	public AppUser toUserEntity() {
		AppUser user = new AppUser();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		return user;
	}

}