package com.group8.pizzaOrderSystem.Controller;

import com.group8.pizzaOrderSystem.foundation.entity.*;
import com.group8.pizzaOrderSystem.foundation.mapper.PizzaMapper;
import com.group8.pizzaOrderSystem.foundation.model.PizzaDTO;
import com.group8.pizzaOrderSystem.foundation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HomePageController {
    private static final String DOMAIN = "localhost:8080";
    private static final String CUSTOM_PIZZA_NAME = "Custom Pizza";
    @Autowired
    DoughService doughService;
    @Autowired
    CheeseService cheeseService;
    @Autowired
    SauceService sauceService;
    @Autowired
    ToppingService toppingService;
    @Autowired
    PizzaService pizzaService;

    @GetMapping(value="/home")
    public Map<String, Object> getHomeEntryPoints() {
        return Map.of("domain", DOMAIN, "menuUrl", "/home/menu");
    }

    @GetMapping(value="/home/menu")
    public Map<String, Object> getMenu() {
        Map<String, Object> map = new HashMap<>();
        map.put("domain", DOMAIN);
        map.put("customPizza", Map.of("pizzaBuilderUrl", "/pizzabuilder"));
        List<PizzaDTO> pizzaDTOList = pizzaService.list().stream()
                .filter(pizza -> !CUSTOM_PIZZA_NAME.equals(pizza.getName()))
                .map(PizzaMapper::toDTO)
                .toList();
        map.put("signaturePizza", pizzaDTOList);
        return map;
    }

    @GetMapping(value = "/home/dough")
    public String getDough() {
        List<Dough> doughList = doughService.list();
        return doughList.toString();
    }

    @GetMapping(value = "/home/cheese")
    public String getCheese() {
        List<Cheese> cheeseList = cheeseService.list();
        return cheeseList.toString();
    }

    @GetMapping(value = "/home/sauce")
    public String getSauce() {
        List<Sauce> sauceList = sauceService.list();
        return sauceList.toString();
    }

    @GetMapping(value = "/home/topping")
    public String getTopping() {
        List<Topping> toppingList = toppingService.list();
        return toppingList.toString();
    }

    @GetMapping(value="/home/signaturePizza")
    public String getSignaturePizza() {
        List<Pizza> pizzaList = pizzaService.list();
        return pizzaList.toString();
    }
}
