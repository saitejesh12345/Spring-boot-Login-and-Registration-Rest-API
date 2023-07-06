package com.example.SpringSecurity.service;


import com.example.SpringSecurity.Repository.EmployeeRepository;
import com.example.SpringSecurity.Response.LoginResponse;
import com.example.SpringSecurity.entity.Employee;
import com.example.SpringSecurity.entity.EmployeeDTO;
import com.example.SpringSecurity.entity.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;



    private  PasswordEncoder passwordEncoder;
    public EmployeServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
        employeeDTO.getEmployeeid(),
        employeeDTO.getEmployeename(),
        employeeDTO.getEmail(),
       passwordEncoder.encode(employeeDTO.getPassword())
        );
        employeeRepository.save(employee);
        return employee.getEmployeename();
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 =  employeeRepository.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee =  employeeRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }

    }
}
