package com.manajemen.demo.controller;

import com.manajemen.demo.model.Instruktur;
import com.manajemen.demo.model.Kursus;
import com.manajemen.demo.service.InstrukturService;
import com.manajemen.demo.service.KursusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kursus")
public class KursusController {

    @Autowired
    private KursusService kursusService;

    @Autowired
    private InstrukturService instrukturService;

    @PostMapping
    public Kursus tambahKursus(@RequestParam String instrukturId, @RequestBody Kursus kursus) {
        Instruktur instruktur = instrukturService.getById(instrukturId);
        if (instruktur == null) return null;
        return kursusService.tambahKursus(kursus, instruktur);
    }

    @GetMapping
    public List<Kursus> getAll() {
        return kursusService.getAllKursus();
    }

    @GetMapping("/{kode}")
    public Kursus getDetail(@PathVariable String kode) {
        return kursusService.getByKode(kode);
    }
}
