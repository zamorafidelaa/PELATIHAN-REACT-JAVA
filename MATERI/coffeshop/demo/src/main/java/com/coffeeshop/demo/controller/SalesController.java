package com.coffeeshop.demo.controller;

import com.coffeeshop.demo.model.Sales;
import com.coffeeshop.demo.model.Coffee;
import com.coffeeshop.demo.model.Barista;
import com.coffeeshop.demo.repository.SalesRepository;
import com.coffeeshop.demo.repository.CoffeeRepository;
import com.coffeeshop.demo.repository.BaristaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private BaristaRepository baristaRepository;

    @GetMapping("/all")
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @PostMapping("/add/{idBarista}/{codeCoffee}")
    public Sales createSales(
            @PathVariable Integer idBarista,
            @PathVariable Integer codeCoffee) {
        Barista barista = baristaRepository.findById(idBarista).orElse(null);
        Coffee coffee = coffeeRepository.findById(codeCoffee).orElse(null);

        if (barista == null || coffee == null) {
            return null;
        }

        Sales sales = new Sales();
        sales.setIdBarista(barista);
        sales.setCodeCoffee(coffee);

        return salesRepository.save(sales);
    }

    @GetMapping("/date/{date}")
    public List<Sales> getSalesByDate(@PathVariable String date) {
        LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return salesRepository.findByDate(parsedDate);
    }
}
