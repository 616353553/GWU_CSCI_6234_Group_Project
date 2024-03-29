package com.group8.pizzaOrderSystem.Controller;

import com.group8.pizzaOrderSystem.foundation.entity.*;
import com.group8.pizzaOrderSystem.foundation.mapper.*;
import com.group8.pizzaOrderSystem.foundation.model.*;
import com.group8.pizzaOrderSystem.foundation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PizzaBuilderController {
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

    @GetMapping(value = "/pizzabuilder")
    public Map<String, Object> getSettings() {
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
        map.put("urls", Map.of("validateUrl", "/pizzabuilder/validate", "getPriceUrl", "/pizzabuilder/getprice"));
        return map;
    }

    @PostMapping(value = "/pizzabuilder/validate")
    public Boolean validatePizza(@RequestBody PizzaDTO pizza) {
        // TODO:
        return true;
    }

    @GetMapping(value = "/pizzabuilder/getprice")
    public BigDecimal getPrice(@RequestBody PizzaDTO pizza) {
        // TODO:
        return BigDecimal.ZERO;
    }








//    @PutMapping(value = "/pizzabuilder/dough/{name}")
//    public String setDough(@PathVariable String name) {
//
//    }
//
//    @PutMapping(value = "/pizzabuilder/doughsize/{name}")
//    public String setDoughSize(@PathVariable String name) {
//
//    }
//
//    @PutMapping(value = "/pizzabuilder/cheese/{id}/{name}")
//    public String setCheese(@PathVariable int id, @PathVariable String name) {
//
//    }
//
//    @PutMapping(value = "/pizzabuilder/cheeselevel/{id}/{name}")
//    public String setCheeseLevel(@PathVariable int id, @PathVariable String name) {
//
//    }
//
//    @PutMapping(value = "/pizzabuilder/sauce/{name}")
//    public String setSauce(@PathVariable String name) {
//
//    }
//
//    @PutMapping(value = "/pizzabuilder/sauceintensity/{name}")
//    public String setSauceIntensity(@PathVariable String name) {
//
//    }
//
//    @PutMapping(value = "/pizzabuilder/topping/{id}/{name}")
//    public String setTopping(@PathVariable int id, @PathVariable String name) {
//
//    }

}
