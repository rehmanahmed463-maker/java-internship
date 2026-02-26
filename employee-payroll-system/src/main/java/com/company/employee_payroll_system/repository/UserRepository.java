package com.company.employee_payroll_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.employee_payroll_system.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
