package com.example.projectsystem.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectsystem.model.Department;
import com.example.projectsystem.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/all")
    public Map<String, Object> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil mengambil semua data department");
        response.put("data", departments);
        return response;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getDepartmentById(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Department department = departmentRepository.findById(id).orElse(null);

        if (department == null) {
            response.put("message", "Department dengan ID " + id + " tidak ditemukan");
        } else {
            response.put("message", "Berhasil mengambil data department");
            response.put("data", department);
        }
        return response;
    }

    @PostMapping("/add")
    public Map<String, Object> addDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentRepository.save(department);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil menyimpan data department");
        response.put("data", savedDepartment);
        return response;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> updateDepartment(@PathVariable Long id, @RequestBody Department newDepartment) {
        Map<String, Object> response = new LinkedHashMap<>();
        Department existing = departmentRepository.findById(id).orElse(null);

        if (existing == null) {
            response.put("message", "Department dengan ID " + id + " tidak ditemukan");
        } else {
            existing.setName(newDepartment.getName());
            Department updatedDepartment = departmentRepository.save(existing);
            response.put("message", "Data department dengan ID " + id + " berhasil diperbarui");
            response.put("data", updatedDepartment);
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteDepartment(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Department toDelete = departmentRepository.findById(id).orElse(null);

        if (toDelete == null) {
            response.put("message", "Department dengan ID " + id + " tidak ditemukan");
        } else {
            departmentRepository.delete(toDelete);
            response.put("message", "Data department dengan ID " + id + " berhasil dihapus");
            response.put("data", toDelete);
        }
        return response;
    }
}
