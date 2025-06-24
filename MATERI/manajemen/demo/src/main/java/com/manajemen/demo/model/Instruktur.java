package com.manajemen.demo.model;

import lombok.Data;
import java.util.UUID;

@Data
public class Instruktur {
    private String id = UUID.randomUUID().toString();
    private String nama;
    private String keahlian;
}