package com.company.employee_payroll_system.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.employee_payroll_system.service.EmployeeService;

@Controller
public class AdminEmployeeController {

    private final EmployeeService employeeService;

    public AdminEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/admin/employees/add")
    public String addEmployee(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam(required = false) String phone,
            @RequestParam String designation,
            @RequestParam Double basicSalary,
            @RequestParam(required = false) String joiningDate, // yyyy-mm-dd
            @RequestParam Long departmentId
    ) {
        try {
            LocalDate jd = (joiningDate == null || joiningDate.isBlank()) ? null : LocalDate.parse(joiningDate);

            employeeService.addEmployee(fullName, email, phone, designation, basicSalary, jd, departmentId);

            return "redirect:/add-employee.html?success=Employee%20added%20successfully";
        } catch (Exception e) {
            return "redirect:/add-employee.html?error=" + e.getMessage().replace(" ", "%20");
        }
    }
}
