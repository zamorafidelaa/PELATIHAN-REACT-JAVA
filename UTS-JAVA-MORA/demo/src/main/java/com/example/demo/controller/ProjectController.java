package com.example.demo.controller;

import com.example.demo.model.Project;
import com.example.demo.model.Department;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.DepartmentRepository;
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

    @GetMapping("/all")
    public Map<String, Object> getAll() {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Project> projects = projectRepository.findAll();
        response.put("message", "Berhasil mengambil semua data project");
        response.put("data", projects);
        return response;
    }

    @GetMapping("/by-id/{id}")
    public Map<String, Object> getById(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Project project = projectRepository.findById(id).orElse(null);
        if (project == null) {
            response.put("message", "Project dengan ID " + id + " tidak ditemukan");
            response.put("data", null);
        } else {
            response.put("message", "Berhasil mengambil project dengan ID " + id);
            response.put("data", project);
        }
        return response;
    }

    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody Project project) {
        Map<String, Object> response = new LinkedHashMap<>();
        Department department = departmentRepository.findById(project.getDepartment().getId()).orElse(null);
        if (department == null) {
            response.put("message", "Department dengan ID " + project.getDepartment().getId() + " tidak ditemukan");
            response.put("data", null);
            return response;
        }
        project.setDepartment(department);
        Project saved = projectRepository.save(project);
        response.put("message", "Project berhasil ditambahkan");
        response.put("data", saved);
        return response;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody Project project) {
        Map<String, Object> response = new LinkedHashMap<>();
        Department department = departmentRepository.findById(project.getDepartment().getId()).orElse(null);
        if (department == null) {
            response.put("message", "Department dengan ID " + project.getDepartment().getId() + " tidak ditemukan");
            response.put("data", null);
            return response;
        }
        project.setId(id);
        project.setDepartment(department);
        Project saved = projectRepository.save(project);
        response.put("message", "Project dengan ID " + id + " berhasil diperbarui");
        response.put("data", saved);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        projectRepository.deleteById(id);
        response.put("message", "Project dengan ID " + id + " berhasil dihapus");
        return response;
    }

    @GetMapping("/search/{title}")
    public Map<String, Object> search(@PathVariable String title) {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Project> projects = projectRepository.findByTitleContainingIgnoreCase(title);
        response.put("message", "Hasil pencarian project dengan title mengandung: " + title);
        response.put("data", projects);
        return response;
    }

    @GetMapping("/sort/asc")
    public Map<String, Object> sortAsc() {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Project> projects = projectRepository.findAllByOrderByTitleAsc();
        response.put("message", "Project diurutkan ascending berdasarkan title");
        response.put("data", projects);
        return response;
    }

    @GetMapping("/sort/desc")
    public Map<String, Object> sortDesc() {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Project> projects = projectRepository.findAllByOrderByTitleDesc();
        response.put("message", "Project diurutkan descending berdasarkan title");
        response.put("data", projects);
        return response;
    }
}
