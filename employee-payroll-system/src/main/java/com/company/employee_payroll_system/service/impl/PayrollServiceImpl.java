package com.company.employee_payroll_system.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.employee_payroll_system.model.Employee;
import com.company.employee_payroll_system.model.Payslip;
import com.company.employee_payroll_system.repository.EmployeeRepository;
import com.company.employee_payroll_system.repository.PayslipRepository;
import com.company.employee_payroll_system.service.PayrollService;

@Service
public class PayrollServiceImpl implements PayrollService {

    private final EmployeeRepository employeeRepo;
    private final PayslipRepository payslipRepo;

    public PayrollServiceImpl(EmployeeRepository employeeRepo, PayslipRepository payslipRepo) {
        this.employeeRepo = employeeRepo;
        this.payslipRepo = payslipRepo;
    }

    /* ================= AUTO / BULK ================= */

    @Transactional
    @Override
    public int generatePayslipsForMonth(String payMonth, String generatedBy, boolean overrideEligibility) {

        int created = 0;
        YearMonth ym = YearMonth.parse(payMonth);

        for (Employee e : employeeRepo.findAll()) {
            created += generateForEmployeeInternal(e, payMonth, generatedBy, overrideEligibility);
        }
        return created;
    }

    /* ================= MANUAL / SELECTED ================= */

    @Transactional
    @Override
    public int generatePayslipForEmployee(
            Long employeeId,
            String payMonth,
            String generatedBy,
            boolean overrideEligibility) {

        Employee e = employeeRepo.findById(employeeId).orElse(null);
        if (e == null) return 0;

        return generateForEmployeeInternal(e, payMonth, generatedBy, overrideEligibility);
    }

    /* ================= CORE LOGIC ================= */

    private int generateForEmployeeInternal(
            Employee e,
            String payMonth,
            String generatedBy,
            boolean overrideEligibility) {

        // prevent duplicate
        if (payslipRepo.findByEmployeeIdAndPayMonth(e.getId(), payMonth).isPresent()) {
            return 0;
        }

        YearMonth ym = YearMonth.parse(payMonth);
        int totalDays = ym.lengthOfMonth();
        LocalDate monthStart = ym.atDay(1);
        LocalDate monthEnd = ym.atEndOfMonth();

        LocalDate join = e.getJoiningDate();
        if (join == null) {
            if (!overrideEligibility) return 0;
            join = monthStart;
        }

        if (join.isAfter(monthEnd) && !overrideEligibility) return 0;

        LocalDate effectiveStart = join.isAfter(monthStart) ? join : monthStart;
        int workedDays = 0;

        if (!effectiveStart.isAfter(monthEnd)) {
            workedDays = (int) (java.time.temporal.ChronoUnit.DAYS
                    .between(effectiveStart, monthEnd) + 1);
        }

        // eligibility
        if (!overrideEligibility && workedDays < 10) return 0;

        double factor = workedDays / (double) totalDays;
        double monthlyBasic = e.getBasicSalary();

        double basic = round2(monthlyBasic * factor);
        double hra = round2(monthlyBasic * 0.20 * factor);
        double pf = round2(monthlyBasic * 0.12 * factor);
        double professionalTax = (workedDays >= 10) ? 200 : 0;

        double totalEarnings = basic + hra;
        double totalDeductions = pf + professionalTax;
        double netPay = totalEarnings - totalDeductions;

        Payslip p = new Payslip();
        p.setEmployee(e);
        p.setPayMonth(payMonth);
        p.setWorkedDays(workedDays);
        p.setTotalDays(totalDays);
        p.setBasic(basic);
        p.setHra(hra);
        p.setIncentive(0.0);
        p.setPf(pf);
        p.setProfessionalTax(professionalTax);
        p.setTotalEarnings(totalEarnings);
        p.setTotalDeductions(totalDeductions);
        p.setNetPay(netPay);
        p.setGeneratedBy(generatedBy);
        p.setGeneratedAt(LocalDateTime.now());

        payslipRepo.save(p);
        return 1;
    }

    private double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}
