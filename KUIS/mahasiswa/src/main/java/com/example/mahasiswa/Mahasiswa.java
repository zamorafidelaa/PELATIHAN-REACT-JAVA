package com.example.mahasiswa;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
    private int tahunMasuk;

    public Mahasiswa() {}

    public Mahasiswa(String nama, String nim, String jurusan, int tahunMasuk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.tahunMasuk = tahunMasuk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public int getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(int tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }
}
