package com.group8.pizzaOrderSystem.foundation.model;

public class CheeseLevelDTO {
    private final String name;

    public CheeseLevelDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("[CheeseLevelDTO %s]", name);
    }
}
