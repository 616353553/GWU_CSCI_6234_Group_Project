package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.Topping;
import com.group8.pizzaOrderSystem.foundation.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ToppingService {

    @Autowired
    private ToppingRepository toppingRepository;

    public List<Topping> list() {
        return toppingRepository.findAll();
    }

    public Optional<Topping> valueWithName(String toppingName) {
        Topping example = new Topping();
        example.setName(toppingName);
        return toppingRepository.findOne(Example.of(example));
    }
    public boolean existWithName(String toppingName) {
        Topping example = new Topping();
        example.setName(toppingName);
        return toppingRepository.exists(Example.of(example));
    }

    public BigDecimal calculateToppingPrice(String toppingName) {
        Optional<Topping> toppingOptional = this.valueWithName(toppingName);
        return toppingOptional.map(Topping::getPrice).orElse(BigDecimal.ZERO);
    }
}
