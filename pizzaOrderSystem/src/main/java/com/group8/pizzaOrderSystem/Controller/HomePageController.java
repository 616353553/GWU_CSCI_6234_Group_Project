package com.group8.pizzaOrderSystem.Controller;

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
    PizzaService pizzaService;

    @GetMapping(value="/home")
    public Map<String, Object> getHomeEntryPoints() {
        return Map.of("domain", DOMAIN, "menuUrl", "/home/menu", "shoppingCartUrl", "/cart");
    }

    @GetMapping(value="/home/menu")
    public Map<String, Object> getMenu() {
        Map<String, Object> map = new HashMap<>();
        map.put("domain", DOMAIN);
        map.put("customPizza", Map.of("pizzaBuilderOptionUrl", "/pizzabuilder/options"));
        List<PizzaDTO> pizzaDTOList = pizzaService.list().stream()
                .filter(pizza -> !CUSTOM_PIZZA_NAME.equals(pizza.getName()))
                .map(PizzaMapper::toDTO)
                .toList();
        map.put("signaturePizza", pizzaDTOList);
        return map;
    }
}
