package com.manajemen.demo.service;

import com.manajemen.demo.model.Peserta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PesertaService {
    private final List<Peserta> pesertaList = new ArrayList<>();

    public Peserta tambahPeserta(Peserta peserta) {
        pesertaList.add(peserta);
        return peserta;
    }

    public List<Peserta> getAllPeserta() {
        return pesertaList;
    }

    public Peserta getById(String id) {
        return pesertaList.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
