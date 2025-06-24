package com.coffeeshop.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeeshop.demo.model.Coffee;
import java.util.List;


public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    List<Coffee> findByCode(Integer code);
}