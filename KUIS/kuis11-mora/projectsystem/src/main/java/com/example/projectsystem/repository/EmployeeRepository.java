package com.example.projectsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectsystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
