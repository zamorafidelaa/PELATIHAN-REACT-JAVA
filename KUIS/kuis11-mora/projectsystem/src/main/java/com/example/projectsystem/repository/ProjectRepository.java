package com.example.projectsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectsystem.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
