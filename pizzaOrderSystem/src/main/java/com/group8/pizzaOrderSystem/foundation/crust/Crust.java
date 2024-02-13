package com.group8.pizzaOrderSystem.foundation.crust;

public class Crust {
    public enum CrustSize {
        SMALL,
        MEDIUM,
        LARGE,
        X_LARGE
    }

    private CrustSize size;

    // Hide the default constructor
    private Crust() {};
}
