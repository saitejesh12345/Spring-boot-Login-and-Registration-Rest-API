package com.example.SpringSecurity.Repository;

import com.example.SpringSecurity.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByEmail(String email);
    Optional<Employee> findOneByEmailAndPassword(String email, String password);
}
