package com.group8.pizzaOrderSystem.foundation.model;

public class DoughSizeDTO {
    private final String name;
    private final Integer inch;

    public DoughSizeDTO(String name, Integer inch) {
        this.name = name;
        this.inch = inch;
    }

    public String getName() {
        return name;
    }

    public Integer getInch() {
        return inch;
    }

    @Override
    public String toString() {
        return String.format("[DoughSize %s (%d inch)]", name, inch);
    }
}
