package com.example.demo.controller;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/all")
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @GetMapping("/by-id/{id}")
    public Company getById(@PathVariable Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody Company company) {
        Company saved = companyRepository.save(company);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Company berhasil ditambahkan");
        response.put("data", saved);
        return response;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody Company updated) {
        updated.setId(id);
        Company saved = companyRepository.save(updated);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Company dengan ID " + id + " berhasil diperbarui");
        response.put("data", saved);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        companyRepository.deleteById(id);
        response.put("message", "Company dengan ID " + id + " berhasil dihapus");
        return response;
    }

    @GetMapping("/search/{name}")
    public Map<String, Object> search(@PathVariable String name) {
        List<Company> results = companyRepository.findByNameContainingIgnoreCase(name);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Hasil pencarian company dengan nama mengandung: " + name);
        response.put("data", results);
        return response;
    }

    @GetMapping("/sort/{order}")
    public Map<String, Object> sort(@PathVariable String order) {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Company> results;
        if (order.equalsIgnoreCase("asc")) {
            results = companyRepository.findAllByOrderByNameAsc();
            response.put("message", "Company diurutkan ascending");
        } else if (order.equalsIgnoreCase("desc")) {
            results = companyRepository.findAllByOrderByNameDesc();
            response.put("message", "Company diurutkan descending");
        } else {
            response.put("message", "Parameter sort tidak valid (gunakan 'asc' atau 'desc')");
            response.put("data", null);
            return response;
        }
        response.put("data", results);
        return response;
    }

}
