package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.Topping;
import com.group8.pizzaOrderSystem.foundation.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingService {

    @Autowired
    private ToppingRepository toppingRepository;

    public List<Topping> list() {
        return toppingRepository.findAll();
    }
}
