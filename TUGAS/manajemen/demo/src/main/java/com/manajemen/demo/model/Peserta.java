package com.manajemen.demo.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Peserta {
    private String id = UUID.randomUUID().toString();
    private String nama;
    private String email;
    private List<Kursus> kursusDiikuti = new ArrayList<>();
}

