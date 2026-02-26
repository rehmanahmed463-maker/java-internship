package com.company.employee_payroll_system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.employee_payroll_system.model.Payslip;

public interface PayslipRepository extends JpaRepository<Payslip, Long> {

    List<Payslip> findByPayMonthOrderByIdDesc(String payMonth);

    Optional<Payslip> findByEmployeeIdAndPayMonth(Long employeeId, String payMonth);
}
