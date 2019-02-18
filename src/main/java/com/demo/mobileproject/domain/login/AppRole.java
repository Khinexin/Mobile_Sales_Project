package com.demo.mobileproject.domain.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "App_Role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "Role_Name") })
public class AppRole {

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_EMP = "ROLE_EMP";

    @Id
    @Column(name = "Role_Id", nullable = false)
    private Integer roleId;

    @Column(name = "Role_Name", length = 30, nullable = false)
    private String roleName;


}