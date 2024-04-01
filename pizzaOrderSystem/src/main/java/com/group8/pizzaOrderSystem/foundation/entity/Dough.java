package com.group8.pizzaOrderSystem.foundation.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name="DOUGHS")
public class Dough {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "DOUGH_DOUGHSIZE",
            joinColumns = @JoinColumn(name = "dough_id"),
            inverseJoinColumns = @JoinColumn(name = "dough_size_id")
    )
    private final Set<DoughSize> supportedDoughSizes = new HashSet<>();
    private BigDecimal price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<DoughSize> getSupportedDoughSizes() {
        return supportedDoughSizes;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("[Dough %d: %s - $%s]", id, name, price.toString());
    }
}
