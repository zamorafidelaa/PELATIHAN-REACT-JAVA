package com.manajemen.demo.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Kursus {
    private String kode = UUID.randomUUID().toString();
    private String namaKursus;
    private int kuota;
    private Instruktur instruktur;
    private List<Peserta> pesertaList = new ArrayList<>();
}