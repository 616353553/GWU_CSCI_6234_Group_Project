package com.group8.pizzaOrderSystem.foundation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity(name="DOUGHSIZES")
public class DoughSize {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer inch;
    private BigDecimal multiplier;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getInch() {
        return inch;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }

    @Override
    public String toString() {
        return String.format("[DoughSize %d: %s : %d %sx]", id, name, inch, multiplier.toString());
    }
}
