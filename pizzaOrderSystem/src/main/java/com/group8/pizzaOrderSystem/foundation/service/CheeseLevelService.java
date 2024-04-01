package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.CheeseLevel;
import com.group8.pizzaOrderSystem.foundation.repository.CheeseLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheeseLevelService {

    @Autowired
    private CheeseLevelRepository cheeseLevelRepository;

    public List<CheeseLevel> list() {
        return cheeseLevelRepository.findAll();
    }

    public Optional<CheeseLevel> valueWithName(String cheeseLevelName) {
        CheeseLevel example = new CheeseLevel();
        example.setName(cheeseLevelName);
        return cheeseLevelRepository.findOne(Example.of(example));
    }
    public boolean existWithName(String cheeseLevelName) {
        CheeseLevel example = new CheeseLevel();
        example.setName(cheeseLevelName);
        return cheeseLevelRepository.exists(Example.of(example));
    }
}