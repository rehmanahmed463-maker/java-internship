package com.company.employee_payroll_system.service;

public interface PayrollService {

    // bulk (scheduler / auto)
    int generatePayslipsForMonth(String payMonth, String generatedBy, boolean overrideEligibility);

    // single / selected employees (manual)
    int generatePayslipForEmployee(
            Long employeeId,
            String payMonth,
            String generatedBy,
            boolean overrideEligibility
    );
}
