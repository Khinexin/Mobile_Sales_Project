package com.demo.mobileproject.service.Impl;

import com.demo.mobileproject.domain.login.AppUser;
import com.demo.mobileproject.repository.AppUserDAO;
import com.demo.mobileproject.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired AppUserDAO appUserDAO;

    @Override
    public AppUser createAppUser(AppUser appUser) {
        return appUserDAO.save(appUser);
    }

    @Override
    public AppUser findAppUserByName(String name) {
        return appUserDAO.findUserAccount(name);
    }

    @Override
    public AppUser findAppUserById(int id) {
        return appUserDAO.getOne(id);
    }

    @Override
    public List<AppUser> findAllUsers() {
        return appUserDAO.findAll();
    }

    @Override
    public void updateAppUser(AppUser appUser) {
        appUserDAO.saveAndFlush(appUser);
    }
}
