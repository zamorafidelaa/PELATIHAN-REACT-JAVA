package com.coffeeshop.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeeshop.demo.model.Barista;

public interface BaristaRepository extends JpaRepository<Barista, Integer> {
    Optional<Barista> findById(Integer id);
}
