package com.manajemen.demo.controller;

import com.manajemen.demo.model.Peserta;
import com.manajemen.demo.service.KursusService;
import com.manajemen.demo.service.PesertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peserta")
public class PesertaController {

    @Autowired
    private PesertaService pesertaService;

    @Autowired
    private KursusService kursusService;

    @PostMapping
    public Peserta tambahPeserta(@RequestBody Peserta peserta) {
        return pesertaService.tambahPeserta(peserta);
    }

    @GetMapping
    public List<Peserta> getAll() {
        return pesertaService.getAllPeserta();
    }

    @PostMapping("/{id}/daftar/{kodeKursus}")
    public String daftar(@PathVariable String id, @PathVariable String kodeKursus) {
        Peserta peserta = pesertaService.getById(id);
        if (peserta == null) return "Peserta tidak ditemukan.";
        return kursusService.daftarPeserta(id, kodeKursus, peserta);
    }
}