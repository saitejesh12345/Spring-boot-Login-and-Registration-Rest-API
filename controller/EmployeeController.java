package com.example.SpringSecurity.controller;


import com.example.SpringSecurity.Response.LoginResponse;
import com.example.SpringSecurity.entity.EmployeeDTO;
import com.example.SpringSecurity.entity.LoginDTO;
import com.example.SpringSecurity.service.EmployeServiceImpl;
import com.example.SpringSecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {


    @Autowired
    private  EmployeeService employeService;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        String id = employeService.addEmployee(employeeDTO);
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = employeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
