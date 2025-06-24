package com.manajemen.demo.service;

import com.manajemen.demo.model.Instruktur;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstrukturService {
    private final List<Instruktur> instrukturs = new ArrayList<>();

    public Instruktur tambahInstruktur(Instruktur instruktur) {
        instrukturs.add(instruktur);
        return instruktur;
    }

    public List<Instruktur> getAllInstruktur() {
        return instrukturs;
    }

    public Instruktur getById(String id) {
        return instrukturs.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
    }
}