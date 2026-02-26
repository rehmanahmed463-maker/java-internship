package com.company.employee_payroll_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/admin/test")
    public String adminTest() {
        return "ADMIN access OK";
    }

    @GetMapping("/hr/test")
    public String hrTest() {
        return "HR access OK";
    }
}
