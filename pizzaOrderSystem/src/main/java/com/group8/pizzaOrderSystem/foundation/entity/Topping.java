package com.group8.pizzaOrderSystem.foundation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity(name="TOPPINGS")
public class Topping {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal price;
    private Boolean veggie;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Boolean getVeggie() {
        return veggie;
    }

    @Override
    public String toString() {
        return String.format("[Sauce %d: %s - $%s %s]", id, name, price.toString(), veggie ? "veggie": "meat");
    }
}