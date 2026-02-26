package com.company.employee_payroll_system;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptHashGen {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin123"));
    }
}
