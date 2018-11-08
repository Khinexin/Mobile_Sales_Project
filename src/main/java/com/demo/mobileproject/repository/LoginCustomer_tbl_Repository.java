package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.LoginCustomer_tbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginCustomer_tbl_Repository extends JpaRepository<LoginCustomer_tbl,Integer> {

    @Query("select c from LoginCustomer_tbl c where c.email=:email and c.password=:password")
    public LoginCustomer_tbl LoginCustomer_tblByEmailAAndPassword(@Param("email") String email, @Param("password") String password);

}
