package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.SauceIntensity;
import com.group8.pizzaOrderSystem.foundation.repository.SauceIntensityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SauceIntensityService {

    @Autowired
    private SauceIntensityRepository sauceIntensityRepository;

    public List<SauceIntensity> list() {
        return sauceIntensityRepository.findAll();
    }
}