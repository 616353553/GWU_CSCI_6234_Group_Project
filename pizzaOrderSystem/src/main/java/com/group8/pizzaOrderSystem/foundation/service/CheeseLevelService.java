package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.CheeseLevel;
import com.group8.pizzaOrderSystem.foundation.repository.CheeseLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheeseLevelService {

    @Autowired
    private CheeseLevelRepository cheeseLevelRepository;

    public List<CheeseLevel> list() {
        return cheeseLevelRepository.findAll();
    }
}