package com.demo.mobileproject.service;

import java.util.List;

import com.demo.mobileproject.entity.AppRole;

public interface AppRoleService {
	
	AppRole createRole(AppRole role);

	AppRole findRoleById(int id);

	AppRole findRoleByName(String name);
	
	long countRole();
	
	List<AppRole> findAllRole();
}
