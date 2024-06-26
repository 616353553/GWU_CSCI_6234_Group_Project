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
    private static final String DOMAIN = "http://localhost:8080";
    private static final String CUSTOM_PIZZA_NAME = "Custom Pizza";
    @Autowired
    PizzaService pizzaService;

    @GetMapping(value="/entrypoints")
    public Map<String, Object> getHomeEntryPoints() {
        return Map.of("domain", DOMAIN, "menuUrl", "/home/menu",
                "clearCartUrl", "/cart/clear",
                "checkoutUrl", "/cart/checkout",
                "removeItemFromCartUrl", "/cart/remove",
                "addSignaturePizzaToCartUrl", "/cart/addsignaturepizza",
                "addCustomPizzaToCartUrl", "/cart/addcustompizza",
                "pizzaBuilderOptionUrl", "/pizzabuilder/options",
                "validateCustomPizzaUrl", "/pizzabuilder/validate",
                "getCustomPizzaPriceUrl", "/pizzabuilder/getprice");
    }

    @GetMapping(value="/home/menu")
    public Map<String, Object> getMenu() {
        Map<String, Object> map = new HashMap<>();
        List<PizzaDTO> pizzaDTOList = pizzaService.list().stream()
                .filter(pizza -> !CUSTOM_PIZZA_NAME.equals(pizza.getName()))
                .map(PizzaMapper::toDTO)
                .toList();
        map.put("signaturePizza", pizzaDTOList);
        return map;
    }
}
