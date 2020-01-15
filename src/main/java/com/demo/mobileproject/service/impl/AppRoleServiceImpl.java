package com.demo.mobileproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mobileproject.entity.AppRole;
import com.demo.mobileproject.repository.AppRoleRepository;
import com.demo.mobileproject.service.AppRoleService;

@Service
public class AppRoleServiceImpl implements AppRoleService{
	
	@Autowired
	private AppRoleRepository roleRepository;

	
	@Override
	public AppRole createRole(AppRole role) {
		return roleRepository.save(role);
	}


	@Override
	public AppRole findRoleById(int id) {
		return roleRepository.getOne(id);
	}


	@Override
	public AppRole findRoleByName(String name) {
		return roleRepository.findRoleByName(name);
	}


	@Override
	public long countRole() {
		return roleRepository.count();
	}


	@Override
	public List<AppRole> findAllRole() {
		return roleRepository.findAll();
	}

	
}
