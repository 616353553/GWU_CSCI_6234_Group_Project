package com.group8.pizzaOrderSystem.foundation.model;

public class SauceDTO {

    private final String name;

    public SauceDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("[SauceDTO %s]", name);
    }
}
