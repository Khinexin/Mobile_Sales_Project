package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.LoginCustomer_tbl;

import java.util.List;

public interface LoginCustomer_tbl_Service {
    LoginCustomer_tbl createLoginCustomerTbl(LoginCustomer_tbl loginCustomer_tbl);
    List<LoginCustomer_tbl> findAllLoginCustomerTbls();
    LoginCustomer_tbl findByIdLoginCustomerTbl(int id);
    void updateLoginCustomer_tbl(int  id);
    void deleteLoginCustomer_tbl(int id);
}
