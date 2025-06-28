package com.example.projectsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectsystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // search
    List<Employee> findByNameContainingIgnoreCase(String name);

    // sorting desc
    List<Employee> findAllByOrderByNameAsc();

    // sorting asc
    List<Employee> findAllByOrderByNameDesc();
}
