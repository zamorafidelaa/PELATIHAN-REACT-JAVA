package com.example.mahasiswa;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MahasiswaService {
    private List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public List<Mahasiswa> getSemuaMahasiswa() {
        return daftarMahasiswa;
    }

    public void tambahMahasiswa(Mahasiswa mahasiswa) {
        daftarMahasiswa.add(mahasiswa);
    }

    public Mahasiswa getMahasiswaByNim(String nim) {
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getNim().equals(nim)) {
                return mhs;
            }
        }
        return null;
    }

    public boolean hapusMahasiswaByNim(String nim) {
        return daftarMahasiswa.removeIf(mhs -> mhs.getNim().equals(nim));
    }

    public Mahasiswa updateMahasiswaByNim(String nim, Mahasiswa mahasiswaBaru) {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i).getNim().equals(nim)) {
                Mahasiswa mhsLama = daftarMahasiswa.get(i);
                mhsLama.setNama(mahasiswaBaru.getNama());
                mhsLama.setJurusan(mahasiswaBaru.getJurusan());
                mhsLama.setTahunMasuk(mahasiswaBaru.getTahunMasuk());
                return mhsLama;
            }
        }
        return null;
    }
}
