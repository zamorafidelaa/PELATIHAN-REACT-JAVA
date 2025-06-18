package com.perusahaan.demo.controller;


import com.perusahaan.demo.model.Proyek;
import com.perusahaan.demo.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @GetMapping
    public List<Proyek> getAll() {
        return proyekService.getAll();
    }

    @PostMapping
    public String addProyek(@RequestBody Proyek proyek) {
        proyekService.addProyek(proyek);
        return "Proyek berhasil ditambahkan";
    }
}
