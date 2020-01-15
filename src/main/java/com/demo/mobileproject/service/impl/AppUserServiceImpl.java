package com.demo.mobileproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mobileproject.entity.AppUser;
import com.demo.mobileproject.repository.AppUserRepository;
import com.demo.mobileproject.service.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService{
	
	@Autowired
	private AppUserRepository userRepository;
	
	@Override
	public AppUser findUserById(int userId	){
		return userRepository.getOne(userId);
	}

	@Override
	public AppUser findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public AppUser createUser(AppUser user) {
		return userRepository.save(user);
	}

	@Override
	public List<AppUser> findUsers() {
		return userRepository.findExcept1And2Id();
	}

	@Override
	public void updateUser(AppUser user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public long countUser() {
		return userRepository.count();
	}
	
	
	
}
