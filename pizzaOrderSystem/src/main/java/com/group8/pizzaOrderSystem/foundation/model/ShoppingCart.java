package com.group8.pizzaOrderSystem.foundation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingCart {
    private final List<PizzaDTO> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(PizzaDTO pizza) {
        this.items.add(pizza);
    }

    public List<PizzaDTO> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return items.stream().map(PizzaDTO::getRetailPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void removeItem(int index) {
        items.remove(index);
    }
}
