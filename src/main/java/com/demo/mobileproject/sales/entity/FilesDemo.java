//package com.demo.mobileproject.sales.entity;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//
//@Entity @Table(name = "files")
//@Data @NoArgsConstructor
//public class FilesDemo {
//
//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    private String id;
//
//    private String fileName;
//
//    private String fileType;
//
//    @Lob @Column(name = "data", unique = true)
//    private byte[] data;
//
//}
