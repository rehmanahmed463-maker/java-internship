package com.company.employee_payroll_system.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.company.employee_payroll_system.repository.UserRepository;
import com.company.employee_payroll_system.service.PayrollService;

@RestController
public class PayrollController {

    private final PayrollService payrollService;
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public PayrollController(PayrollService payrollService,
                             UserRepository userRepo,
                             PasswordEncoder passwordEncoder) {
        this.payrollService = payrollService;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // manual generate for selected employees
    @PostMapping("/admin/payroll/generate-selected")
    public ResponseEntity<?> generateSelected(
            @RequestParam String month,
            @RequestParam String password,
            @RequestParam List<Long> employeeIds,
            Authentication auth) {

        var user = userRepo.findByUsername(auth.getName()).orElseThrow();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.status(401).body("Wrong password");
        }

        int count = 0;
        for (Long empId : employeeIds) {
            count += payrollService.generatePayslipForEmployee(
                    empId, month, auth.getName(), true
            );
        }

        return ResponseEntity.ok("Generated " + count + " payslips");
    }
}
