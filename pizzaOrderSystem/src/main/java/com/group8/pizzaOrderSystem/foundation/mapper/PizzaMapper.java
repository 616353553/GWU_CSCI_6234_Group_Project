package com.group8.pizzaOrderSystem.foundation.mapper;

import com.group8.pizzaOrderSystem.foundation.entity.Pizza;
import com.group8.pizzaOrderSystem.foundation.model.PizzaDTO;

public class PizzaMapper {
    public static PizzaDTO toDTO(Pizza pizza) {
        return new PizzaDTO(pizza.getName(), pizza.getDough().getName(), pizza.getDoughSize().getName(),
                pizza.getCheese1().getName(), pizza.getCheeseLevel1().getName(), pizza.getCheese2().getName(),
                pizza.getCheeseLevel2().getName(), pizza.getSauce().getName(), pizza.getSauceIntensity().getName(),
                pizza.getTopping1().getName(), pizza.getTopping2().getName(), pizza.getTopping3().getName(),
                pizza.getRetailPrice());
    }

//    public static Pizza toEntity(DoughDTO doughDTO) {
//        Dough dough = new Dough();
//        dough.setId(doughDTO.getId());
//        dough.setName(doughDTO.getName());
//        dough.setPrice(doughDTO.getPrice());
//        return dough;
//    }
}
