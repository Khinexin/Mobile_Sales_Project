package com.demo.mobileproject.security.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class AuthenticatedUser extends User {

	private static final long serialVersionUID = 1L;
	private AppUser user;

	public AuthenticatedUser(AppUser user) {
		super(user.getEmail(), user.getPassword(), getAuthorities(user));
		this.user = user;
	}

	public AppUser getUser() {
		return user;
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(AppUser user) {
		Set<String> roleAndPermissions = new HashSet<>();
		List<AppRole> roles = user.getRoles();

		for (AppRole role : roles) {
			roleAndPermissions.add(role.getName());
		}
		String[] roleNames = new String[roleAndPermissions.size()];
		Collection<GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList(roleAndPermissions.toArray(roleNames));
		return authorities;
	}
}