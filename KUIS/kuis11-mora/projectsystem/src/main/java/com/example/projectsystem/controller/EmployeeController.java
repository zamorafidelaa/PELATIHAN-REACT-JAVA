package com.example.projectsystem.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.projectsystem.model.Employee;
import com.example.projectsystem.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public Map<String, Object> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil mengambil semua data employee");
        response.put("data", employees);
        return response;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getEmployeeById(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee == null) {
            response.put("message", "Employee dengan ID " + id + " tidak ditemukan");
        } else {
            response.put("message", "Berhasil mengambil data employee");
            response.put("data", employee);
        }
        return response;
    }

    // search
    @GetMapping("/search/{name}")
    public List<Employee> searchByName(@PathVariable String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    // sorting
    @GetMapping("/sort/asc")
    public List<Employee> sortByNameAsc() {
        return employeeRepository.findAllByOrderByNameAsc();
    }

    @GetMapping("/sort/desc")
    public List<Employee> sortByNameDesc() {
        return employeeRepository.findAllByOrderByNameDesc();
    }

    @PostMapping("/add")
    public Map<String, Object> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil menyimpan data employee");
        response.put("data", savedEmployee);
        return response;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployee) {
        Map<String, Object> response = new LinkedHashMap<>();
        Employee existing = employeeRepository.findById(id).orElse(null);

        if (existing == null) {
            response.put("message", "Employee dengan ID " + id + " tidak ditemukan");
        } else {
            existing.setName(newEmployee.getName());
            Employee updatedEmployee = employeeRepository.save(existing);
            response.put("message", "Data employee dengan ID " + id + " berhasil diperbarui");
            response.put("data", updatedEmployee);
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteEmployee(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Employee toDelete = employeeRepository.findById(id).orElse(null);

        if (toDelete == null) {
            response.put("message", "Employee dengan ID " + id + " tidak ditemukan");
        } else {
            employeeRepository.delete(toDelete);
            response.put("message", "Data employee dengan ID " + id + " berhasil dihapus");
            response.put("data", toDelete);
        }
        return response;
    }
}
