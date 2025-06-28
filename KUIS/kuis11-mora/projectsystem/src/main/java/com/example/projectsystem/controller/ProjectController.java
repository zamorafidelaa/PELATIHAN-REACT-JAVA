package com.example.projectsystem.controller;

import com.example.projectsystem.model.Project;
import com.example.projectsystem.model.Department;
import com.example.projectsystem.model.Employee;
import com.example.projectsystem.repository.ProjectRepository;
import com.example.projectsystem.repository.DepartmentRepository;
import com.example.projectsystem.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getProjectById(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Project project = projectRepository.findById(id).orElse(null);
        if (project == null) {
            response.put("message", "Project dengan ID " + id + " tidak ditemukan");
            response.put("data", null);
        } else {
            response.put("message", "Project ditemukan");
            response.put("data", project);
        }
        return response;
    }

    @PostMapping("/add/{departmentId}/{employeeId}/{title}")
    public Map<String, Object> addProject(@PathVariable Long departmentId,
                                          @PathVariable Long employeeId,
                                          @PathVariable String title) {
        Map<String, Object> response = new LinkedHashMap<>();
        Department department = departmentRepository.findById(departmentId).orElse(null);
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if (department == null || employee == null) {
            response.put("message", "Department atau Employee tidak ditemukan");
            response.put("data", null);
            return response;
        }

        Project project = new Project();
        project.setTitle(title);
        project.setIdDepartment(department);
        project.setIdEmployee(employee);

        Project savedProject = projectRepository.save(project);
        response.put("message", "Project berhasil ditambahkan");
        response.put("data", savedProject);
        return response;
    }

    @PutMapping("/update/{id}/{departmentId}/{employeeId}/{title}")
    public Map<String, Object> updateProject(@PathVariable Long id,
                                             @PathVariable Long departmentId,
                                             @PathVariable Long employeeId,
                                             @PathVariable String title) {
        Map<String, Object> response = new LinkedHashMap<>();
        Project project = projectRepository.findById(id).orElse(null);
        Department department = departmentRepository.findById(departmentId).orElse(null);
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if (project == null || department == null || employee == null) {
            response.put("message", "Project, Department, atau Employee tidak ditemukan");
            response.put("data", null);
            return response;
        }

        project.setTitle(title);
        project.setIdDepartment(department);
        project.setIdEmployee(employee);

        Project updatedProject = projectRepository.save(project);
        response.put("message", "Project berhasil diperbarui");
        response.put("data", updatedProject);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteProject(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Project project = projectRepository.findById(id).orElse(null);

        if (project == null) {
            response.put("message", "Project dengan ID " + id + " tidak ditemukan");
            response.put("data", null);
        } else {
            projectRepository.delete(project);
            response.put("message", "Project berhasil dihapus");
            response.put("data", project);
        }
        return response;
    }
}
