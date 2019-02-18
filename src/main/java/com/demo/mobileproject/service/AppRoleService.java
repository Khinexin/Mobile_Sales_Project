package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.login.AppRole;

import java.util.List;

public interface AppRoleService {
    AppRole findAppRoleById(int id);
    List<String> findAppRoleNameByUserId(int userId);
}
