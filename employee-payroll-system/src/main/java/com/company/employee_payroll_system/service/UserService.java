package com.company.employee_payroll_system.service;

import com.company.employee_payroll_system.model.User;

public interface UserService {

    User saveUser(User user);

    User findByUsername(String username);
}
