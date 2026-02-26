package com.company.employee_payroll_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.employee_payroll_system.model.Department;
import com.company.employee_payroll_system.repository.DepartmentRepository;

@RestController
public class DepartmentApiController {

    private final DepartmentRepository departmentRepo;

    public DepartmentApiController(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @GetMapping("/api/departments")
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }
}
