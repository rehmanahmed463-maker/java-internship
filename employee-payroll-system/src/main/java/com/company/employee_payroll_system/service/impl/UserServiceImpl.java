package com.company.employee_payroll_system.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.employee_payroll_system.model.User;
import com.company.employee_payroll_system.repository.UserRepository;
import com.company.employee_payroll_system.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }
}
