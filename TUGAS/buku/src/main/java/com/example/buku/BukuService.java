package com.example.buku;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BukuService {
    private List<Buku> daftarBuku = new ArrayList<>();

    public List<Buku> getSemuaBuku() {
        return daftarBuku;
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public Buku getBukuById(String id) {
        for (Buku buku : daftarBuku) {
            if (buku.getId().equals(id)) {
                return buku;
            }
        }
        return null;
    }
}    
