package com.example.SpringSecurity.service;

import com.example.SpringSecurity.Response.LoginResponse;
import com.example.SpringSecurity.entity.EmployeeDTO;
import com.example.SpringSecurity.entity.LoginDTO;

public interface EmployeeService {


        String addEmployee(EmployeeDTO employeeDTO);
       LoginResponse loginEmployee(LoginDTO loginDTO);
    }

