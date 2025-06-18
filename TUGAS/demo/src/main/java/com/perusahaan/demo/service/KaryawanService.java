package com.perusahaan.demo.service;

import com.perusahaan.demo.model.Karyawan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KaryawanService {
    private final List<Karyawan> daftarKaryawan = new ArrayList<>();

    @Autowired
    private ProyekService proyekService;

    public List<Karyawan> getAll() {
        return daftarKaryawan;
    }

    public String addKaryawan(Karyawan karyawan) {
        for (String kode : karyawan.getKodeProyek()) {
            if (!proyekService.isKodeProyekValid(kode)) {
                return "Kode proyek tidak ditemukan: " + kode;
            }
        }

        daftarKaryawan.add(karyawan);
        return "Karyawan berhasil ditambahkan";
    }
}
