package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.Cheese;
import com.group8.pizzaOrderSystem.foundation.repository.CheeseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheeseService {

    @Autowired
    private CheeseRepository cheeseRepository;

    public List<Cheese> list() {
        return cheeseRepository.findAll();
    }
}
