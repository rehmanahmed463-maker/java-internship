package com.company.employee_payroll_system.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.company.employee_payroll_system.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Long departmentId);
}
