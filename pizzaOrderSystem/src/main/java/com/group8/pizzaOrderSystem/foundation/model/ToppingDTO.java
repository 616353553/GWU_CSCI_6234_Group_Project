package com.group8.pizzaOrderSystem.foundation.model;

public class ToppingDTO {
    private final String name;
    private final Boolean veggie;

    public ToppingDTO(String name, Boolean veggie) {
        this.name = name;
        this.veggie = veggie;
    }

    public String getName() {
        return name;
    }

    public Boolean getVeggie() {
        return veggie;
    }

    @Override
    public String toString() {
        return String.format("[Sauce %s is %s]", name, veggie ? "veggie": "meat");
    }
}
