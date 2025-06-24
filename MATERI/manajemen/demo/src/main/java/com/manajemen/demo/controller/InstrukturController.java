package com.manajemen.demo.controller;

import com.manajemen.demo.model.Instruktur;
import com.manajemen.demo.service.InstrukturService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instruktur")
public class InstrukturController {

    @Autowired
    private InstrukturService instrukturService;

    @PostMapping
    public Instruktur tambahInstruktur(@RequestBody Instruktur instruktur) {
        return instrukturService.tambahInstruktur(instruktur);
    }

    @GetMapping
    public List<Instruktur> getAll() {
        return instrukturService.getAllInstruktur();
    }
}