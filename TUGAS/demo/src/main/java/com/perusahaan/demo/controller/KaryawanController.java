package com.perusahaan.demo.controller;

import com.perusahaan.demo.model.Karyawan;
import com.perusahaan.demo.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {

    @Autowired
    private KaryawanService karyawanService;

    @GetMapping
    public List<Karyawan> getAll() {
        return karyawanService.getAll();
    }

    @PostMapping
    public String addKaryawan(@RequestBody Karyawan karyawan) {
        return karyawanService.addKaryawan(karyawan);
    }
}
