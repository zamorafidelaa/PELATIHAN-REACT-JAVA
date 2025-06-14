package com.example.mahasiswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @GetMapping
    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaService.getSemuaMahasiswa();
    }

    @PostMapping
    public ResponseEntity<String> tambahMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        mahasiswaService.tambahMahasiswa(mahasiswa);
        return ResponseEntity.ok("Mahasiswa berhasil ditambahkan.");
    }

    @GetMapping("/{nim}")
    public ResponseEntity<?> getMahasiswaByNim(@PathVariable String nim) {
        Mahasiswa mhs = mahasiswaService.getMahasiswaByNim(nim);
        if (mhs != null) {
            return ResponseEntity.ok(mhs);
        } else {
            return ResponseEntity.status(404).body("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    @DeleteMapping("/{nim}")
    public ResponseEntity<String> hapusMahasiswa(@PathVariable String nim) {
        boolean berhasil = mahasiswaService.hapusMahasiswaByNim(nim);
        if (berhasil) {
            return ResponseEntity.ok("Mahasiswa berhasil dihapus.");
        } else {
            return ResponseEntity.status(404).body("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    @PutMapping("/{nim}")
    public ResponseEntity<String> updateMahasiswa(@PathVariable String nim, @RequestBody Mahasiswa mahasiswaBaru) {
        Mahasiswa updated = mahasiswaService.updateMahasiswaByNim(nim, mahasiswaBaru);
        if (updated != null) {
            return ResponseEntity.ok("Mahasiswa berhasil diperbarui.");
        } else {
            return ResponseEntity.status(404).body("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }
}
