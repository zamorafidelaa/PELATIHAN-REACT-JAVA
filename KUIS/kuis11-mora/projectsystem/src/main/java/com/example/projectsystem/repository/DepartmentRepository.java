package com.example.projectsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectsystem.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
