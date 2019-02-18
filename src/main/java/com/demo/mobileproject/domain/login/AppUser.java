package com.demo.mobileproject.domain.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "App_User", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name") })
public class AppUser {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id", nullable = false)
    private Integer userId;

    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;

    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;

    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;


    @NotEmpty(message = "*Please provide your first name")
    private String firstName;

    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    private String country;
    private String customerPhone;
    private String emailAddress;


    //for two factor authentication
//    @Column(name = "is_tfa_enable", length = 1)
//    private String is_tfa_enable;
//    @Column(name = "tfa_default_type", length = 45)
//    private String tfa_default_type;
//    @Column(name = "tfa_expire_time", length = 45)
//    private String tfa_expire_time;
//    @Column(name = "tfa_code", length = 10)
//    private String tfa_code;


}