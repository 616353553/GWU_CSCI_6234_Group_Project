package com.group8.pizzaOrderSystem.foundation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity(name="SAUCEINTENSITIES")
public class SauceIntensity {

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

    @Override
    public String toString() {
        return String.format("[SauceIntensity %d: %s : %sx]", id, name, multiplier.toString());
    }
}