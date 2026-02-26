package com.company.employee_payroll_system.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.company.employee_payroll_system.model.Payslip;
import com.company.employee_payroll_system.repository.PayslipRepository;

@RestController
public class PayslipApiController {

    private final PayslipRepository payslipRepo;

    public PayslipApiController(PayslipRepository payslipRepo) {
        this.payslipRepo = payslipRepo;
    }

    // ✅ list payslips by month
    @GetMapping("/api/payslips")
    public List<Payslip> listByMonth(@RequestParam String month) {
        return payslipRepo.findByPayMonthOrderByIdDesc(month);
    }

    // ✅ get single payslip
    @GetMapping("/api/payslip/{id}")
    public ResponseEntity<Payslip> one(@PathVariable Long id) {
        return payslipRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
