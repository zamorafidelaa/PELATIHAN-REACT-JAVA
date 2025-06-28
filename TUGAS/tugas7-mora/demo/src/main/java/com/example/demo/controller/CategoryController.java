package com.example.demo.controller;

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

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    public Map<String, Object> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil mengambil semua data category");
        response.put("data", categories);
        return response;
    }

    @GetMapping("/by-id/{id}")
    public Map<String, Object> getCategoryById(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Category category = categoryRepository.findById(id).orElse(null);

        if (category == null) {
            response.put("message", "Category dengan ID " + id + " tidak ditemukan");
        } else {
            response.put("message", "Berhasil mengambil data category");
            response.put("data", category);
        }
        return response;
    }

    @PostMapping("/save")
    public Map<String, Object> addCategory(@RequestBody Category category) {
        Category savedCategory = categoryRepository.save(category);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil menyimpan data category");
        response.put("data", savedCategory);
        return response;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> updateCategory(@PathVariable Long id, @RequestBody Category newCategory) {
        Map<String, Object> response = new LinkedHashMap<>();
        Category existing = categoryRepository.findById(id).orElse(null);

        if (existing == null) {
            response.put("message", "Category dengan ID " + id + " tidak ditemukan");
        } else {
            existing.setName(newCategory.getName());
            Category updatedCategory = categoryRepository.save(existing);
            response.put("message", "Data category dengan ID " + id + " berhasil diperbarui");
            response.put("data", updatedCategory);
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteCategory(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Category toDelete = categoryRepository.findById(id).orElse(null);

        if (toDelete == null) {
            response.put("message", "Category dengan ID " + id + " tidak ditemukan");
        } else {
            categoryRepository.delete(toDelete);
            response.put("message", "Data category dengan ID " + id + " berhasil dihapus");
            response.put("data", toDelete);
        }
        return response;
    }
}
