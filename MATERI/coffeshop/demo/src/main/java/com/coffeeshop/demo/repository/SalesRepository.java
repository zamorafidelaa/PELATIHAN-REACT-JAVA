package com.coffeeshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeeshop.demo.model.Sales;

import java.time.LocalDate;
import java.util.List;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
    List<Sales> findByDate(LocalDate date);
}
