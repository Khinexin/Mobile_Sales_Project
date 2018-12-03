package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.login.AppUser;
import com.demo.mobileproject.domain.login.UserRole;

public interface CustomUserRoleService {

    UserRole addNewUserAndRole(UserRole userRole);
}
