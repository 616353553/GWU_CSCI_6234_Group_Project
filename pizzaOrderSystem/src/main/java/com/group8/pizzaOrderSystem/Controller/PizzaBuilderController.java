package com.group8.pizzaOrderSystem.Controller;

import com.group8.pizzaOrderSystem.foundation.mapper.*;
import com.group8.pizzaOrderSystem.foundation.model.*;
import com.group8.pizzaOrderSystem.foundation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PizzaBuilderController {
    private static final String DOMAIN = "http://localhost:8080";

    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private DoughService doughService;
    @Autowired
    private CheeseService cheeseService;
    @Autowired
    private CheeseLevelService cheeseLevelService;
    @Autowired
    private SauceService sauceService;
    @Autowired
    private SauceIntensityService sauceIntensityService;
    @Autowired
    private ToppingService toppingService;

    @GetMapping(value = "/pizzabuilder/options")
    public Map<String, Object> getOptions() {
        Map<String, Object> map = new HashMap<>();
        List<DoughDTO> doughList = doughService.list().stream().map(DoughMapper::toDTO).toList();
        List<CheeseDTO> cheeseList = cheeseService.list().stream().map(CheeseMapper::toDTO).toList();
        List<CheeseLevelDTO> cheeseLevelList = cheeseLevelService.list().stream().map(CheeseLevelMapper::toDTO).toList();
        List<SauceDTO> sauceList = sauceService.list().stream().map(SauceMapper::toDTO).toList();
        List<SauceIntensityDTO> sauceIntensityList = sauceIntensityService.list().stream().map(SauceIntensityMapper::toDTO).toList();
        List<ToppingDTO> toppingList = toppingService.list().stream().map(ToppingMapper::toDTO).toList();
        map.put("doughs", doughList);
        map.put("cheeses", cheeseList);
        map.put("cheeseLevels", cheeseLevelList);
        map.put("sauces", sauceList);
        map.put("sauceIntensities", sauceIntensityList);
        map.put("toppings", toppingList);
        return map;
    }

    @PostMapping(value = "/pizzabuilder/validate")
    public Map<String, Object> validatePizza(@RequestBody PizzaDTO pizza) {
        String errMsg = pizzaService.validatePizza(pizza);
        return Map.of("valid", errMsg.isBlank(), "errMsg", errMsg);
    }

    @PostMapping(value = "/pizzabuilder/getprice")
    public Map<String, Object> getPrice(@RequestBody PizzaDTO pizza) {
        return Map.of("price", pizzaService.getPrice(pizza));
    }
}
