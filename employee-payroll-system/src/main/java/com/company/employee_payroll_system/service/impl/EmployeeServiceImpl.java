package com.company.employee_payroll_system.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.company.employee_payroll_system.model.Department;
import com.company.employee_payroll_system.model.Employee;
import com.company.employee_payroll_system.repository.DepartmentRepository;
import com.company.employee_payroll_system.repository.EmployeeRepository;
import com.company.employee_payroll_system.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final DepartmentRepository departmentRepo;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo, DepartmentRepository departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    @Override
    public Employee addEmployee(String fullName, String email, String phone,
                                String designation, Double basicSalary,
                                LocalDate joiningDate, Long departmentId) {

        if (fullName == null || fullName.trim().isEmpty())
            throw new IllegalArgumentException("Full name is required");
        if (email == null || email.trim().isEmpty())
            throw new IllegalArgumentException("Email is required");
        if (designation == null || designation.trim().isEmpty())
            throw new IllegalArgumentException("Designation is required");
        if (basicSalary == null || basicSalary <= 0)
            throw new IllegalArgumentException("Basic salary must be > 0");
        if (departmentId == null)
            throw new IllegalArgumentException("Department ID is required");

        Department dept = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new IllegalArgumentException("Department not found with ID: " + departmentId));

        Employee e = new Employee();
        e.setFullName(fullName.trim());
        e.setEmail(email.trim());
        e.setPhone(phone == null ? null : phone.trim());
        e.setDesignation(designation.trim());
        e.setBasicSalary(basicSalary);
        e.setJoiningDate(joiningDate);
        e.setDepartment(dept);

        return employeeRepo.save(e);
    }
}
