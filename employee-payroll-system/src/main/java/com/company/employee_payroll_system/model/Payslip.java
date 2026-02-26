package com.company.employee_payroll_system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "payslips",
        uniqueConstraints = @UniqueConstraint(columnNames = {"employee_id", "pay_month"})
)
public class Payslip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "pay_month", nullable = false) // format: YYYY-MM
    private String payMonth;

    @Column(nullable = false)
    private Double basic;

    @Column(nullable = false)
    private Double hra;

    @Column(nullable = false)
    private Double incentive;

    @Column(nullable = false)
    private Double pf;

    @Column(nullable = false)
    private Double professionalTax;

    @Column(nullable = false)
    private Double totalEarnings;

    @Column(nullable = false)
    private Double totalDeductions;

    @Column(nullable = false)
    private Double netPay;

    @Column(nullable = false)
    private Integer workedDays;

    @Column(nullable = false)
    private Integer totalDays;


    private String generatedBy; // username or "SYSTEM"
    private LocalDateTime generatedAt;

    // getters/setters
    public Long getId() { return id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public String getPayMonth() { return payMonth; }
    public void setPayMonth(String payMonth) { this.payMonth = payMonth; }

    public Double getBasic() { return basic; }
    public void setBasic(Double basic) { this.basic = basic; }

    public Double getHra() { return hra; }
    public void setHra(Double hra) { this.hra = hra; }

    public Double getIncentive() { return incentive; }
    public void setIncentive(Double incentive) { this.incentive = incentive; }

    public Double getPf() { return pf; }
    public void setPf(Double pf) { this.pf = pf; }

    public Double getProfessionalTax() { return professionalTax; }
    public void setProfessionalTax(Double professionalTax) { this.professionalTax = professionalTax; }

    public Double getTotalEarnings() { return totalEarnings; }
    public void setTotalEarnings(Double totalEarnings) { this.totalEarnings = totalEarnings; }

    public Double getTotalDeductions() { return totalDeductions; }
    public void setTotalDeductions(Double totalDeductions) { this.totalDeductions = totalDeductions; }

    public Double getNetPay() { return netPay; }
    public void setNetPay(Double netPay) { this.netPay = netPay; }

    public Integer getWorkedDays() { return workedDays; }
    public void setWorkedDays(Integer workedDays) { this.workedDays = workedDays; }

    public Integer getTotalDays() { return totalDays; }
    public void setTotalDays(Integer totalDays) { this.totalDays = totalDays; }


    public String getGeneratedBy() { return generatedBy; }
    public void setGeneratedBy(String generatedBy) { this.generatedBy = generatedBy; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
}
