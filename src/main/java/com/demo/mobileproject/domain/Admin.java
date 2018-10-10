package com.demo.mobileproject.domain;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "admin_tbl")
public class Admin implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;


    //getter//setter
    //.equal // hushcode
    //toString
   
}
