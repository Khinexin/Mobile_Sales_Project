package com.demo.mobileproject.service;

import java.util.List;

import com.demo.mobileproject.entity.AppUser;


public interface AppUserService {
	
	AppUser findUserById(int userId);

	AppUser findUserByEmail(String email);

	AppUser createUser(AppUser user);
	
	List<AppUser> findUsers();
	
	void updateUser(AppUser user);
	
	long countUser();
}
