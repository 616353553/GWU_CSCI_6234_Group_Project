package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.Sauce;
import com.group8.pizzaOrderSystem.foundation.repository.SauceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SauceService {

    @Autowired
    private SauceRepository sauceRepository;

    public List<Sauce> list() {
        return sauceRepository.findAll();
    }
}
