package com.demo.mobileproject.service.Impl;

import com.demo.mobileproject.domain.login.AppRole;
import com.demo.mobileproject.repository.AppRoleDAO;
import com.demo.mobileproject.service.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleServiceImpl implements AppRoleService {

    @Autowired AppRoleDAO appRoleDAO;

    @Override
    public AppRole findAppRoleById(int id) {
        return appRoleDAO.getOne(id);
    }

    @Override
    public List<String> findAppRoleNameByUserId(int userId) {
        return appRoleDAO.getRoleNamesByUserId(userId);
    }
}
