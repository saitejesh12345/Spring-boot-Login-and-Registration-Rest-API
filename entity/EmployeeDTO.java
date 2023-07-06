package com.example.SpringSecurity.entity;


import lombok.Data;

@Data
public class EmployeeDTO {

        private int employeeid;
        private String employeename;
        private String email;
        private String password;
        public EmployeeDTO() {
        }

        public EmployeeDTO(int employeeid, String employeename, String email, String password) {
            this.employeeid = employeeid;
            this.employeename = employeename;
            this.email = email;
            this.password = password;
        }

    } //create getters and setters

