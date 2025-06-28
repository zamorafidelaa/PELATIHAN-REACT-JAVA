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

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/all")
    public Map<String, Object> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil mengambil semua data author");
        response.put("data", authors);
        return response;
    }

    @GetMapping("/by-id/{id}")
    public Map<String, Object> getAuthorById(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Author author = authorRepository.findById(id).orElse(null);

        if (author == null) {
            response.put("message", "Author dengan ID " + id + " tidak ditemukan");
        } else {
            response.put("message", "Berhasil mengambil data author");
            response.put("data", author);
        }
        return response;
    }

    @PostMapping("/save")
    public Map<String, Object> addAuthor(@RequestBody Author author) {
        Author savedAuthor = authorRepository.save(author);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil menyimpan data author");
        response.put("data", savedAuthor);
        return response;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> updateAuthor(@PathVariable Long id, @RequestBody Author newAuthor) {
        Map<String, Object> response = new LinkedHashMap<>();
        Author existing = authorRepository.findById(id).orElse(null);

        if (existing == null) {
            response.put("message", "Author dengan ID " + id + " tidak ditemukan");
        } else {
            existing.setName(newAuthor.getName());
            Author updatedAuthor = authorRepository.save(existing);
            response.put("message", "Data author dengan ID " + id + " berhasil diperbarui");
            response.put("data", updatedAuthor);
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteAuthor(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Author toDelete = authorRepository.findById(id).orElse(null);

        if (toDelete == null) {
            response.put("message", "Author dengan ID " + id + " tidak ditemukan");
        } else {
            authorRepository.delete(toDelete);
            response.put("message", "Data author dengan ID " + id + " berhasil dihapus");
            response.put("data", toDelete);
        }
        return response;
    }
}