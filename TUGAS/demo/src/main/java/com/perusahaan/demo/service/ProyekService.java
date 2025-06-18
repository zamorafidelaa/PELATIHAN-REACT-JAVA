package com.perusahaan.demo.service;

import com.perusahaan.demo.model.Proyek;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProyekService {
    private List<Proyek> daftarProyek = new ArrayList<>();

    public List<Proyek> getAll() {
        return daftarProyek;
    }

    public void addProyek(Proyek proyek) {
        daftarProyek.add(proyek);
    }

    public boolean isKodeProyekValid(String kode) {
        return daftarProyek.stream().anyMatch(p -> p.getKode().equals(kode));
    }
}
