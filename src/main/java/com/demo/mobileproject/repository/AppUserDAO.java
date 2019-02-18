package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.login.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserDAO extends JpaRepository<AppUser,Integer> {

    @Query("SELECT e FROM AppUser e WHERE e.userName=:userName")
    AppUser findUserAccount(@Param("userName") String userName);

    @Query("SELECT e FROM AppUser e WHERE e.emailAddress=:email")
    Optional<AppUser> findUserAccountByEmail(@Param("email") String email);

}