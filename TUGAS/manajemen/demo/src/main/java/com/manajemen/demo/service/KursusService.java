package com.manajemen.demo.service;

import com.manajemen.demo.model.Instruktur;
import com.manajemen.demo.model.Kursus;
import com.manajemen.demo.model.Peserta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KursusService {
    private final List<Kursus> kursusList = new ArrayList<>();

    public Kursus tambahKursus(Kursus kursus, Instruktur instruktur) {
        kursus.setInstruktur(instruktur);
        kursusList.add(kursus);
        return kursus;
    }

    public List<Kursus> getAllKursus() {
        return kursusList;
    }

    public Kursus getByKode(String kode) {
        return kursusList.stream().filter(k -> k.getKode().equals(kode)).findFirst().orElse(null);
    }

    public String daftarPeserta(String idPeserta, String kodeKursus, Peserta peserta) {
        Kursus kursus = getByKode(kodeKursus);
        if (kursus == null) return "Kursus tidak ditemukan.";
        if (kursus.getPesertaList().size() >= kursus.getKuota()) return "Kuota penuh.";

        if (!kursus.getPesertaList().contains(peserta)) {
            kursus.getPesertaList().add(peserta);
            peserta.getKursusDiikuti().add(kursus);
            return "Pendaftaran berhasil.";
        }
        return "Peserta sudah terdaftar.";
    }
}