package com.company.employee_payroll_system.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.company.employee_payroll_system.model.Employee;
import com.company.employee_payroll_system.repository.EmployeeRepository;

@RestController
public class EmployeeApiController {

    private final EmployeeRepository repo;

    public EmployeeApiController(EmployeeRepository repo) {
        this.repo = repo;
    }

    // ✅ Department-wise employees (USED by employee-report.html + employee-details.html)
    @GetMapping("/api/employees")
    public List<Employee> byDepartment(@RequestParam Long departmentId) {
        return repo.findByDepartmentId(departmentId);
    }

    // ✅ All employees (USED by salary.html manual search/select)
    @GetMapping("/api/employees-all")
    public List<Employee> all() {
        return repo.findAll();
    }

    // ✅ Single employee (USED by details pages if needed)
    @GetMapping("/api/employee/{id}")
    public ResponseEntity<Employee> one(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
