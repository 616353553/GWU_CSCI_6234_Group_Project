package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.Pizza;
import com.group8.pizzaOrderSystem.foundation.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> list() {
        return pizzaRepository.findAll();
    }
}
