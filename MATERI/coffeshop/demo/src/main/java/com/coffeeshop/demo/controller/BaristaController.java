package com.coffeeshop.demo.controller;

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

import com.coffeeshop.demo.model.Barista;
import com.coffeeshop.demo.repository.BaristaRepository;

@RestController
@RequestMapping("/barista")
public class BaristaController {
    @Autowired
    private BaristaRepository baristaRepository;

    @GetMapping("/all")
    public Map<String, Object> getAllBaristas() {
        List<Barista> baristas = baristaRepository.findAll();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil mengambil semua data barista");
        response.put("data", baristas);
        return response;
    }

    @GetMapping("/getById/{id}")
    public Map<String, Object> getBaristaById(@PathVariable Integer id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Barista barista = baristaRepository.findById(id).orElse(null);

        if (barista == null) {
            response.put("message", "Barista dengan ID " + id + " tidak ditemukan");
        } else {
            response.put("message", "Berhasil mengambil data barista");
            response.put("data", barista);
        }
        return response;
    }

    @PostMapping("/addBarista")
    public Map<String, Object> addBarista(@RequestBody Barista barista) {
        Barista savedBarista = baristaRepository.save(barista);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Berhasil menyimpan data barista");
        response.put("data", savedBarista);
        return response;
    }

    @PutMapping("/updateById/{id}")
    public Map<String, Object> updateBarista(@PathVariable Integer id, @RequestBody Barista newBarista) {
        Map<String, Object> response = new LinkedHashMap<>();
        Barista existing = baristaRepository.findById(id).orElse(null);

        if (existing == null) {
            response.put("message", "Barista dengan ID " + id + " tidak ditemukan");
        } else {
            existing.setName(newBarista.getName());
            existing.setAge(newBarista.getAge());
            existing.setGender(newBarista.getGender());
            existing.setEmail(newBarista.getEmail());
            Barista updatedBarista = baristaRepository.save(existing);
            response.put("message", "Data barista dengan ID " + id + " berhasil diperbarui");
            response.put("data", updatedBarista);
        }
        return response;
    }

    @DeleteMapping("/deleteById{id}")
    public Map<String, Object> deleteBarista(@PathVariable Integer id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Barista toDelete = baristaRepository.findById(id).orElse(null);

        if (toDelete == null) {
            response.put("message", "Barista dengan ID " + id + " tidak ditemukan");
        } else {
            baristaRepository.delete(toDelete);
            response.put("message", "Data barista dengan ID " + id + " berhasil dihapus");
            response.put("data", toDelete);
        }
        return response;
    }
}