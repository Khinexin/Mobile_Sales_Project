package com.demo.mobileproject.security.service;

import java.util.List;

import com.demo.mobileproject.security.entity.AppUser;


public interface AppUserService {
	
	AppUser findUserById(int userId);

	AppUser findUserByEmail(String email);

	AppUser createUser(AppUser user);
	
	List<AppUser> findUsers();
	
	void updateUser(AppUser user);
	
	long countUser();
}
