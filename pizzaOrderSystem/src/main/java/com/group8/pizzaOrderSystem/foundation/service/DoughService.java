package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.Dough;
import com.group8.pizzaOrderSystem.foundation.entity.DoughSize;
import com.group8.pizzaOrderSystem.foundation.repository.DoughRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DoughService {

    @Autowired
    private DoughRepository doughRepository;

    public List<Dough> list() {
        return doughRepository.findAll();
    }

    public boolean existWithName(String doughName) {
        Dough dough = new Dough();
        dough.setName(doughName);
        return doughRepository.exists(Example.of(dough));
    }

    public Optional<Dough> valueWithName(String doughName) {
        Dough example = new Dough();
        example.setName(doughName);
        return doughRepository.findOne(Example.of(example));
    }

    public boolean haveDoughSize(String doughName, String doughSize) {
        Dough example = new Dough();
        example.setName(doughName);
        Optional<Dough> dough = doughRepository.findOne(Example.of(example));
        if (dough.isEmpty()) {
            return false;
        }
        Set<String> setNames = dough.get().getSupportedDoughSizes().stream().map(DoughSize::getName)
                .collect(Collectors.toSet());
        return setNames.contains(doughSize);
    }

    public BigDecimal calculateDoughPrice(String doughName, String doughSizeName) {
        Optional<Dough> doughNullable = this.valueWithName(doughName);
        if (doughNullable.isPresent()) {
            Dough dough = doughNullable.get();
            Optional<DoughSize> doughSize = dough.getSupportedDoughSizes().stream()
                    .filter(ds -> ds.getName().equals(doughSizeName))
                    .findFirst();
            return doughSize.map(size -> dough.getPrice().multiply(size.getMultiplier())).orElseGet(dough::getPrice);
        }
        return BigDecimal.ZERO;
    }
}