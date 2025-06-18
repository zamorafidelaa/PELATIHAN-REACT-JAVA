package com.perusahaan.demo.model;

import lombok.Data;
import java.util.List;

@Data
public class Karyawan {
    private String id;
    private String nama;
    private String jabatan;
    private List<String> kodeProyek;
}
