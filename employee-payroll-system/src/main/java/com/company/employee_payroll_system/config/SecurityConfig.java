package com.company.employee_payroll_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        // ✅ Public resources (no login)
                        .requestMatchers("/login.html", "/css/**", "/images/**").permitAll()

                        // ✅ Logged-in users can access APIs + static pages
                        .requestMatchers(
                                "/dashboard.html",
                                "/add-department.html",
                                "/add-employee.html",
                                "/employee-report.html",
                                "/employee-details.html",
                                "/salary.html",
                                "/payslip.html"
                        ).authenticated()

                        // ✅ APIs that need login
                        .requestMatchers(
                                "/api/departments",
                                "/api/employees",
                                "/api/employees-all",
                                "/api/employee/**",
                                "/api/payslips",
                                "/api/payslip/**"
                        ).authenticated()

                        // ✅ Admin-only backend actions
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // ✅ anything else
                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login.html")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/dashboard.html", true)
                        .failureUrl("/login.html?error")
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/login.html")
                        .permitAll()
                );

        return http.build();
    }
}
