package com.company.employee_payroll_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.employee_payroll_system.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByNameIgnoreCase(String name);
}
