package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.Sauce;
import com.group8.pizzaOrderSystem.foundation.entity.SauceIntensity;
import com.group8.pizzaOrderSystem.foundation.repository.SauceIntensityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SauceIntensityService {

    @Autowired
    private SauceIntensityRepository sauceIntensityRepository;

    public List<SauceIntensity> list() {
        return sauceIntensityRepository.findAll();
    }

    public Optional<SauceIntensity> valueWithName(String sauceIntensityName) {
        SauceIntensity example = new SauceIntensity();
        example.setName(sauceIntensityName);
        return sauceIntensityRepository.findOne(Example.of(example));
    }
    public boolean existWithName(String sauceIntensityName) {
        SauceIntensity example = new SauceIntensity();
        example.setName(sauceIntensityName);
        return sauceIntensityRepository.exists(Example.of(example));
    }
}