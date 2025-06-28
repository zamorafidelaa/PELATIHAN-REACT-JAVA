package com.example.projectsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "id_department", referencedColumnName = "id")
    private Department idDepartment;
    @ManyToOne
    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    private Employee idEmployee;

}
