package com.demo.mobileproject.service.Impl;

import com.demo.mobileproject.domain.login.UserRole;
import com.demo.mobileproject.repository.UserRoleRepository;
import com.demo.mobileproject.service.CustomUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomUserRoleServiceImpl implements CustomUserRoleService {

    @Autowired UserRoleRepository userRoleRepository;

    @Override
    public UserRole addNewUserAndRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }
}
