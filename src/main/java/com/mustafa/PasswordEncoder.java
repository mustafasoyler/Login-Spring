package com.mustafa;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String psswd="123454435";
        String encodepswd = passwordEncoder.encode(psswd);

        System.out.println(encodepswd);
    }
}
