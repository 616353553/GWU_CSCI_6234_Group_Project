package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.Cheese;
import com.group8.pizzaOrderSystem.foundation.entity.CheeseLevel;
import com.group8.pizzaOrderSystem.foundation.repository.CheeseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CheeseService {

    @Autowired
    private CheeseRepository cheeseRepository;
    @Autowired
    private CheeseLevelService cheeseLevelService;

    public List<Cheese> list() {
        return cheeseRepository.findAll();
    }

    public Optional<Cheese> valueWithName(String cheeseName) {
        Cheese example = new Cheese();
        example.setName(cheeseName);
        return cheeseRepository.findOne(Example.of(example));
    }
    public boolean existWithName(String cheeseName) {
        Cheese example = new Cheese();
        example.setName(cheeseName);
        return cheeseRepository.exists(Example.of(example));
    }

    public BigDecimal calculateCheesePrice(String cheeseName, String cheeseLevelName) {
        Optional<Cheese> cheeseOptional = this.valueWithName(cheeseName);
        if (cheeseOptional.isPresent()) {
            Cheese cheese = cheeseOptional.get();
            Optional<CheeseLevel> cheeseLevel = cheeseLevelService.valueWithName(cheeseLevelName);
            return cheeseLevel.map(level -> cheese.getPrice().multiply(level.getMultiplier())).orElseGet(cheese::getPrice);
        }
        return BigDecimal.ZERO;
    }
}
