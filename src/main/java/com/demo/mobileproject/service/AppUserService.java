package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.login.AppUser;

import java.util.List;

public interface AppUserService {

    AppUser createAppUser(AppUser appUser);
    AppUser findAppUserByName(String name);
    AppUser findAppUserById(int id);

    List<AppUser> findAllUsers();

    void updateAppUser(AppUser appUser);

}
