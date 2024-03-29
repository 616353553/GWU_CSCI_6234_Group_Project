package com.group8.pizzaOrderSystem.foundation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity(name="CHEESELEVELS")
public class CheeseLevel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal multiplier;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMultiplier(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public String toString() {
        return String.format("[CheeseLevel %d: %s : %sx]", id, name, multiplier.toString());
    }
}