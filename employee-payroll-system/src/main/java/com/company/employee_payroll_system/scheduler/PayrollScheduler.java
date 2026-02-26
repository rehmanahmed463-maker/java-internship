package com.company.employee_payroll_system.scheduler;

import java.time.YearMonth;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.company.employee_payroll_system.service.PayrollService;

@Component
public class PayrollScheduler {

    private final PayrollService payrollService;

    public PayrollScheduler(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    /**
     * Runs automatically on 7th day of every month at 10:00 AM (India time)
     * Generates payslips for current month
     * Eligibility rule applies (workedDays >= 10)
     * overrideEligibility = false
     */
    @Scheduled(cron = "0 0 10 7 * *", zone = "Asia/Kolkata")
    public void generateMonthlyPayslips() {

        String month = YearMonth.now().toString(); // "YYYY-MM"

        int created = payrollService.generatePayslipsForMonth(
                month,
                "SYSTEM",
                false // ✅ don't override eligibility in auto run
        );

        System.out.println("✅ Scheduler: Generated " + created + " payslips for " + month);
    }
}
