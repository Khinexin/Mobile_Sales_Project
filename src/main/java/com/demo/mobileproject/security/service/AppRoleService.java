package com.demo.mobileproject.security.service;

import java.util.List;

import com.demo.mobileproject.security.entity.AppRole;

public interface AppRoleService {
	
	AppRole createRole(AppRole role);

	AppRole findRoleById(int id);

	AppRole findRoleByName(String name);
	
	long countRole();
	
	List<AppRole> findAllRole();
}
