package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
    List<Task> findByStatusIgnoreCase(String status);

    List<Task> findByProjectId(Long projectId);

    List<Task> findByStatusIgnoreCaseAndProjectId(String status, Long projectId);

    List<Task> findAllByOrderByNameAsc();

    List<Task> findAllByOrderByNameDesc();

}
