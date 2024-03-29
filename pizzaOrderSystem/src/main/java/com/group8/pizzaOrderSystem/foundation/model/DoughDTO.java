package com.group8.pizzaOrderSystem.foundation.model;

import java.util.Set;

public class DoughDTO {
    private final String name;

    private final Set<DoughSizeDTO> supportedDoughSizes;

    public DoughDTO(String name, Set<DoughSizeDTO> doughSizeList) {
        this.name = name;
        this.supportedDoughSizes = doughSizeList;
    }

    public String getName() {
        return name;
    }

    public Set<DoughSizeDTO> getSupportedDoughSizes() {
        return supportedDoughSizes;
    }

    @Override
    public String toString() {
        return String.format("[DoughDTO %s comes in %s]", name, supportedDoughSizes.toString());
    }
}
