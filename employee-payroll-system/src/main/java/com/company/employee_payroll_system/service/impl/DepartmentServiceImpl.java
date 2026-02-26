package com.company.employee_payroll_system.service.impl;

import org.springframework.stereotype.Service;

import com.company.employee_payroll_system.model.Department;
import com.company.employee_payroll_system.repository.DepartmentRepository;
import com.company.employee_payroll_system.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repo;

    public DepartmentServiceImpl(DepartmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Department addDepartment(String name) {
        String n = (name == null) ? "" : name.trim();
        if (n.isEmpty()) throw new IllegalArgumentException("Department name cannot be empty");

        if (repo.findByNameIgnoreCase(n).isPresent()) {
            throw new IllegalArgumentException("Department already exists");
        }

        Department d = new Department();
        d.setName(n);
        return repo.save(d);
    }
}
