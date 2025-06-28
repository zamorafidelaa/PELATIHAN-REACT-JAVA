package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.Author;
import com.example.demo.model.Category;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/save")
    public Map<String, Object> saveBook(@RequestBody Book book) {
        Map<String, Object> response = new LinkedHashMap<>();

        Long authorId = book.getAuthor() != null ? book.getAuthor().getId() : null;
        Long categoryId = book.getCategory() != null ? book.getCategory().getId() : null;

        Author author = authorRepository.findById(authorId).orElse(null);
        Category category = categoryRepository.findById(categoryId).orElse(null);

        if (author == null || category == null) {
            response.put("message", "Author atau Category tidak ditemukan");
            response.put("data", null);
            return response;
        }

        book.setAuthor(author);
        book.setCategory(category);

        Book saved = bookRepository.save(book);
        response.put("message", "Book berhasil disimpan");
        response.put("data", saved);
        return response;
    }

    @GetMapping("/by-id/{id}")
    public Map<String, Object> getBookById(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            response.put("message", "Book dengan ID " + id + " tidak ditemukan");
        } else {
            response.put("message", "Berhasil mengambil data book");
            response.put("data", book);
        }
        return response;
    }

@PutMapping("/update/{id}")
public Map<String, Object> updateBook(@PathVariable Long id, @RequestBody Book newBook) {
    Map<String, Object> response = new LinkedHashMap<>();
    Book existing = bookRepository.findById(id).orElse(null);
    if (existing == null) {
        response.put("message", "Book dengan ID " + id + " tidak ditemukan");
    } else {
        existing.setName(newBook.getName());

        Long authorId = newBook.getAuthor() != null ? newBook.getAuthor().getId() : null;
        Long categoryId = newBook.getCategory() != null ? newBook.getCategory().getId() : null;

        Author author = authorRepository.findById(authorId).orElse(null);
        Category category = categoryRepository.findById(categoryId).orElse(null);

        if (author == null || category == null) {
            response.put("message", "Author atau Category tidak ditemukan");
            response.put("data", null);
            return response;
        }

        existing.setAuthor(author);
        existing.setCategory(category);

        Book updated = bookRepository.save(existing);
        response.put("message", "Book berhasil diperbarui");
        response.put("data", updated);
    }
    return response;
}

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteBook(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            response.put("message", "Book dengan ID " + id + " tidak ditemukan");
        } else {
            bookRepository.delete(book);
            response.put("message", "Book berhasil dihapus");
            response.put("data", book);
        }
        return response;
    }
}
