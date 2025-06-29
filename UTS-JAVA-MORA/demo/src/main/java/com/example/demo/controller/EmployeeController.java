package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.Department;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/all")
    public Map<String, Object> getAll() {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Employee> data = employeeRepository.findAll();
        response.put("message", "Berhasil mengambil semua data employee");
        response.put("data", data);
        return response;
    }

    @GetMapping("/by-id/{id}")
    public Map<String, Object> getById(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            response.put("message", "Employee dengan ID " + id + " tidak ditemukan");
            response.put("data", null);
        } else {
            response.put("message", "Employee dengan ID " + id + " berhasil ditemukan");
            response.put("data", employee);
        }
        return response;
    }

    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody Employee employee) {
        Map<String, Object> response = new LinkedHashMap<>();
        if (employee.getDepartment() == null || employee.getDepartment().getId() == null) {
            response.put("message", "Department ID wajib disertakan");
            response.put("data", null);
            return response;
        }
        Department department = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
        if (department == null) {
            response.put("message", "Department dengan ID " + employee.getDepartment().getId() + " tidak ditemukan");
            response.put("data", null);
            return response;
        }
        employee.setDepartment(department);
        Employee saved = employeeRepository.save(employee);
        response.put("message", "Employee berhasil ditambahkan");
        response.put("data", saved);
        return response;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody Employee employee) {
        Map<String, Object> response = new LinkedHashMap<>();
        if (employee.getDepartment() == null || employee.getDepartment().getId() == null) {
            response.put("message", "Department ID wajib disertakan");
            response.put("data", null);
            return response;
        }
        Department department = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
        if (department == null) {
            response.put("message", "Department dengan ID " + employee.getDepartment().getId() + " tidak ditemukan");
            response.put("data", null);
            return response;
        }
        employee.setId(id);
        employee.setDepartment(department);
        Employee saved = employeeRepository.save(employee);
        response.put("message", "Employee dengan ID " + id + " berhasil diperbarui");
        response.put("data", saved);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        employeeRepository.deleteById(id);
        response.put("message", "Employee dengan ID " + id + " berhasil dihapus");
        return response;
    }

    @GetMapping("/search/{fullName}")
    public Map<String, Object> search(@PathVariable String fullName) {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Employee> data = employeeRepository.findByFullNameContainingIgnoreCase(fullName);
        response.put("message", "Hasil pencarian employee dengan fullName: " + fullName);
        response.put("data", data);
        return response;
    }

    @GetMapping("/sort/asc")
    public Map<String, Object> sortAsc() {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Employee> data = employeeRepository.findAllByOrderByFullNameAsc();
        response.put("message", "Data employee diurutkan ascending berdasarkan nama");
        response.put("data", data);
        return response;
    }

    @GetMapping("/sort/desc")
    public Map<String, Object> sortDesc() {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Employee> data = employeeRepository.findAllByOrderByFullNameDesc();
        response.put("message", "Data employee diurutkan descending berdasarkan nama");
        response.put("data", data);
        return response;
    }
}
