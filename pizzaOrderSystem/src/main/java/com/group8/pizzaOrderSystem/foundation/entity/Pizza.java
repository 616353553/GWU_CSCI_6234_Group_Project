package com.group8.pizzaOrderSystem.foundation.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name="PIZZAS")
public class Pizza {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne()
    @JoinColumn(name = "dough_id", referencedColumnName = "id")
    private Dough dough;

    @ManyToOne()
    @JoinColumn(name = "dough_size_id", referencedColumnName = "id")
    private DoughSize doughSize;

    @ManyToOne()
    @JoinColumn(name = "cheese_id_1", referencedColumnName = "id")
    private Cheese cheese1;

    @ManyToOne()
    @JoinColumn(name = "cheese_level_id_1", referencedColumnName = "id")
    private CheeseLevel cheeseLevel1;

    @ManyToOne()
    @JoinColumn(name = "cheese_id_2", referencedColumnName = "id")
    private Cheese cheese2;

    @ManyToOne()
    @JoinColumn(name = "cheese_level_id_2", referencedColumnName = "id")
    private CheeseLevel cheeseLevel2;

    @ManyToOne()
    @JoinColumn(name = "sauce_id", referencedColumnName = "id")
    private Sauce sauce;

    @ManyToOne()
    @JoinColumn(name = "sauce_intensity_id", referencedColumnName = "id")
    private SauceIntensity sauceIntensity;

    @ManyToOne()
    @JoinColumn(name = "topping_id_1", referencedColumnName = "id")
    private Topping topping1;

    @ManyToOne()
    @JoinColumn(name = "topping_id_2", referencedColumnName = "id")
    private Topping topping2;

    @ManyToOne()
    @JoinColumn(name = "topping_id_3", referencedColumnName = "id")
    private Topping topping3;

    @Column(name = "retail_price")
    private BigDecimal retailPrice;

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Dough getDough() {
        return dough;
    }

    public DoughSize getDoughSize() {
        return doughSize;
    }

    public Cheese getCheese1() {
        return cheese1;
    }

    public CheeseLevel getCheeseLevel1() {
        return cheeseLevel1;
    }

    public Cheese getCheese2() {
        return cheese2;
    }

    public CheeseLevel getCheeseLevel2() {
        return cheeseLevel2;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public SauceIntensity getSauceIntensity() {
        return sauceIntensity;
    }

    public Topping getTopping1() {
        return topping1;
    }

    public Topping getTopping2() {
        return topping2;
    }

    public Topping getTopping3() {
        return topping3;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    @Override
    public String toString() {
        return String.format("[Pizza %d: %s - $%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s]",
                id, name, retailPrice.toString(), dough.toString(), doughSize.toString(), cheese1.toString(),
                cheeseLevel1.toString(), cheese2.toString(), cheeseLevel2.toString(), sauce.toString(),
                sauceIntensity.toString(), topping1.toString(), topping2.toString(), topping3.toString());
    }
//    @Override
//    public String toString() {
//        return String.format("[Pizza %d: %s - $%s]", id, name, retailPrice.toString());
//    }
}