package com.demo.mobileproject.domain.login;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPasswordUtils {

    // Encryte Password with BCryptPasswordEncoder
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) throws InterruptedException {
        String password = "12345";
        String encrytedPassword = encrytePassword(password);
        System.out.println("Encryted Password: " + encrytedPassword);

    }


}
