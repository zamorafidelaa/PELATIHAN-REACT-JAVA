package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.model.Company;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/all")
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @GetMapping("/by-id/{id}")
    public Department getById(@PathVariable Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody Department department) {
        Map<String, Object> response = new LinkedHashMap<>();
        if (department.getCompany() == null || department.getCompany().getId() == null) {
            response.put("message", "Company ID wajib diisi pada data Department");
            response.put("data", null);
            return response;
        }

        Company company = companyRepository.findById(department.getCompany().getId()).orElse(null);
        if (company == null) {
            response.put("message", "Company dengan ID " + department.getCompany().getId() + " tidak ditemukan");
            response.put("data", null);
            return response;
        }

        department.setCompany(company);
        Department saved = departmentRepository.save(department);
        response.put("message", "Department berhasil ditambahkan");
        response.put("data", saved);
        return response;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody Department department) {
        Map<String, Object> response = new LinkedHashMap<>();
        if (department.getCompany() == null || department.getCompany().getId() == null) {
            response.put("message", "Company ID wajib disertakan di data");
            response.put("data", null);
            return response;
        }

        Company company = companyRepository.findById(department.getCompany().getId()).orElse(null);
        if (company == null) {
            response.put("message", "Company dengan ID " + department.getCompany().getId() + " tidak ditemukan");
            response.put("data", null);
            return response;
        }

        department.setId(id);
        department.setCompany(company);
        Department saved = departmentRepository.save(department);
        response.put("message", "Department dengan ID " + id + " berhasil diperbarui");
        response.put("data", saved);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        departmentRepository.deleteById(id);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Department dengan ID " + id + " berhasil dihapus");
        return response;
    }

    @GetMapping("/search/{name}")
    public Map<String, Object> search(@PathVariable String name) {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Department> results = departmentRepository.findByNameContainingIgnoreCase(name);
        response.put("message", "Hasil pencarian department dengan nama mengandung: " + name);
        response.put("data", results);
        return response;
    }

    @GetMapping("/sort/{order}")
    public Map<String, Object> sort(@PathVariable String order) {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Department> results;
        if (order.equalsIgnoreCase("asc")) {
            results = departmentRepository.findAllByOrderByNameAsc();
            response.put("message", "Department diurutkan ascending");
        } else if (order.equalsIgnoreCase("desc")) {
            results = departmentRepository.findAllByOrderByNameDesc();
            response.put("message", "Department diurutkan descending");
        } else {
            response.put("message", "Parameter order tidak valid (gunakan 'asc' atau 'desc')");
            response.put("data", null);
            return response;
        }
        response.put("data", results);
        return response;
    }

}
