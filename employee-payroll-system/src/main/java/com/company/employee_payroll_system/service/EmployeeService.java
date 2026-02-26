package com.company.employee_payroll_system.service;

import java.time.LocalDate;
import com.company.employee_payroll_system.model.Employee;

public interface EmployeeService {
    Employee addEmployee(String fullName, String email, String phone,
                         String designation, Double basicSalary,
                         LocalDate joiningDate, Long departmentId);
}
