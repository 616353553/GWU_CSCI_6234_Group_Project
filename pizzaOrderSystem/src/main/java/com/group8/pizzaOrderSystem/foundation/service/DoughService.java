package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.Dough;
import com.group8.pizzaOrderSystem.foundation.repository.DoughRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoughService {

    @Autowired
    private DoughRepository doughRepository;

    public List<Dough> list() {
        return doughRepository.findAll();
    }
}