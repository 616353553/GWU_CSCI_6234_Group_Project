package com.group8.pizzaOrderSystem.foundation.model;

public class CheeseDTO {
    private final String name;

    public CheeseDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("[CheeseDTO %s]", name);
    }
}
