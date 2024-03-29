package com.group8.pizzaOrderSystem.foundation.model;

public class SauceIntensityDTO {
    private final String name;

    public SauceIntensityDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("[SauceIntensity %s]", name);
    }
}
