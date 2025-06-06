package com.example.buku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/buku")
public class BukuController {

    @Autowired
    private BukuService bukuService;

    @GetMapping
    public List<Buku> getAllBuku() {
        return bukuService.getSemuaBuku();
    }

    @PostMapping
    public Buku tambahBuku(@RequestBody Buku buku) {
        bukuService.tambahBuku(buku);
        return buku;
    }

    @GetMapping("/{id}")
    public Buku getBukuById(@PathVariable String id) {
        return bukuService.getBukuById(id);
    }
}
