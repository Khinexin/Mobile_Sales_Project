package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.LoginCustomer_tbl;
import com.demo.mobileproject.repository.LoginCustomer_tbl_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginCustomer_tbl_ServiceImpl implements LoginCustomer_tbl_Service {
    @Autowired
    private LoginCustomer_tbl_Repository loginCustomer_tbl_repository;

    @Override
    public LoginCustomer_tbl createLoginCustomerTbl(LoginCustomer_tbl loginCustomer_tbl) {
        return loginCustomer_tbl_repository.save(loginCustomer_tbl);
    }

    @Override
    public List<LoginCustomer_tbl> findAllLoginCustomerTbls() {
        return loginCustomer_tbl_repository.findAll();
    }

    @Override
    public LoginCustomer_tbl findByIdLoginCustomerTbl(int id) {
        return loginCustomer_tbl_repository.findById(id).orElse(null);
    }

    @Override
    public void updateLoginCustomer_tbl(int id) {
        loginCustomer_tbl_repository.saveAndFlush(findByIdLoginCustomerTbl(id));
    }

    @Override
    public void deleteLoginCustomer_tbl(int id) {
        loginCustomer_tbl_repository.delete(findByIdLoginCustomerTbl(id));
    }

    @Override
    public LoginCustomer_tbl loginByEmailAndPassword(String email, String password) {
        return loginCustomer_tbl_repository.LoginCustomer_tblByEmailAAndPassword(email, password);
    }
}
