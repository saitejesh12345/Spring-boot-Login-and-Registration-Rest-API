package com.example.SpringSecurity.entity;


import lombok.Data;

@Data
public class LoginDTO {


        private String email;
        private String password;
        public LoginDTO() {
        }
        public LoginDTO(String email, String password) {
            this.email = email;
            this.password = password;
        } //create getters and setters
}
