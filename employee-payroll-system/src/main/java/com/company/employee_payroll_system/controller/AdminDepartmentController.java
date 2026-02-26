package com.company.employee_payroll_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.employee_payroll_system.service.DepartmentService;

@Controller
public class AdminDepartmentController {

    private final DepartmentService departmentService;

    public AdminDepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/admin/departments/add")
    public String addDepartment(@RequestParam String name) {
        try {
            departmentService.addDepartment(name);
            return "redirect:/department.html?success=Department%20added%20successfully";
        } catch (Exception e) {
            return "redirect:/department.html?error=" + e.getMessage().replace(" ", "%20");
        }
    }
}
