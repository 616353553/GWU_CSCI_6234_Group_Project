package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.Sauce;
import com.group8.pizzaOrderSystem.foundation.entity.SauceIntensity;
import com.group8.pizzaOrderSystem.foundation.repository.SauceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SauceService {

    @Autowired
    private SauceRepository sauceRepository;
    @Autowired
    private SauceIntensityService sauceIntensityService;

    public List<Sauce> list() {
        return sauceRepository.findAll();
    }

    public Optional<Sauce> valueWithName(String sauceName) {
        Sauce example = new Sauce();
        example.setName(sauceName);
        return sauceRepository.findOne(Example.of(example));
    }

    public boolean existWithName(String sauceName) {
        Sauce example = new Sauce();
        example.setName(sauceName);
        return sauceRepository.exists(Example.of(example));
    }

    public BigDecimal calculateSaucePrice(String sauceName, String sauceIntensityName) {
        Optional<Sauce> sauceOptional = this.valueWithName(sauceName);
        if (sauceOptional.isPresent()) {
            Sauce sauce = sauceOptional.get();
            Optional<SauceIntensity> sauceIntensity = sauceIntensityService.valueWithName(sauceIntensityName);
            return sauceIntensity.map(intensity -> sauce.getPrice().multiply(intensity.getMultiplier())).orElseGet(sauce::getPrice);
        }
        return BigDecimal.ZERO;
    }
}
