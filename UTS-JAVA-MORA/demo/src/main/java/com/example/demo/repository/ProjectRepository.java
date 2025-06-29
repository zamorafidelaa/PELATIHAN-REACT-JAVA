package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByTitleContainingIgnoreCase(String fullName);

    List<Project> findAllByOrderByTitleAsc();

    List<Project> findAllByOrderByTitleDesc();

}
