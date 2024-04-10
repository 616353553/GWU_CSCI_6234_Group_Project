package com.group8.pizzaOrderSystem.foundation.service;

import com.group8.pizzaOrderSystem.foundation.entity.*;
import com.group8.pizzaOrderSystem.foundation.model.PizzaDTO;
import com.group8.pizzaOrderSystem.foundation.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    private static final String CUSTOM_PIZZA = "Custom Pizza";
    private static final String NONE_TOPPING = "None";

    @Autowired
    private PizzaRepository pizzaRepository;
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

    public Optional<Pizza> valueWithName(String pizzaName) {
        Pizza example = new Pizza();
        example.setName(pizzaName);
        return pizzaRepository.findOne(Example.of(example));
    }
    public List<Pizza> list() {
        return pizzaRepository.findAll();
    }


    public String validatePizza(PizzaDTO pizza) {
        String errMsg = "";
        if (!CUSTOM_PIZZA.equalsIgnoreCase(pizza.getName())) {
            errMsg = "Invalid pizza name [" + pizza.getName() + "]";
        } else if (!doughService.existWithName(pizza.getDoughName())) {
            errMsg = "Unknown dough [" + pizza.getDoughName() + "]";
        } else if (!doughService.haveDoughSize(pizza.getDoughName(), pizza.getDoughSizeName())) {
            errMsg = "Unsupported dough size [" + pizza.getDoughSizeName() + "]";
        } else if (!cheeseService.existWithName(pizza.getCheeseName1()) ||
                !cheeseService.existWithName(pizza.getCheeseName2())) {
            errMsg = "Invalid cheese [" + pizza.getCheeseName1() + ", " + pizza.getCheeseName2() + "]";
        } else if (!cheeseLevelService.existWithName(pizza.getCheeseLevelName1()) ||
                !cheeseLevelService.existWithName(pizza.getCheeseLevelName2())) {
            errMsg = "Invalid cheese level [" + pizza.getCheeseLevelName1() + ", " + pizza.getCheeseLevelName2() + "]";
        }
        if (!sauceService.existWithName(pizza.getSauceName())) {
            errMsg = "Unknown sauce [" + pizza.getSauceName() + "]";
        } else if (!sauceIntensityService.existWithName(pizza.getSauceIntensityName())) {
            errMsg = "Unknown sauce intensity [" + pizza.getSauceIntensityName() + "]";
        } else if (NONE_TOPPING.equals(pizza.getToppingName1())
                && NONE_TOPPING.equals(pizza.getToppingName2())
                && NONE_TOPPING.equals(pizza.getToppingName3())) {
            errMsg = "Pizza must have at least 1 topping";
        } else if (!toppingService.existWithName(pizza.getToppingName1()) ||
                !toppingService.existWithName(pizza.getToppingName2()) ||
                !toppingService.existWithName(pizza.getToppingName3())) {
            errMsg = "Unknown toppings [" + pizza.getToppingName1() + ", " + pizza.getToppingName2() +
                    ", " + pizza.getToppingName3() + "]";
        }
        return errMsg;
    }

    public BigDecimal getPrice(PizzaDTO pizza) {
        if (CUSTOM_PIZZA.equalsIgnoreCase(pizza.getName())) {
            BigDecimal sum = doughService.calculateDoughPrice(pizza.getDoughName(), pizza.getDoughSizeName());
            sum = sum.add(cheeseService.calculateCheesePrice(pizza.getCheeseName1(), pizza.getCheeseLevelName1())
                    .multiply(BigDecimal.valueOf(0.5)));
            sum = sum.add(cheeseService.calculateCheesePrice(pizza.getCheeseName2(), pizza.getCheeseLevelName2())
                    .multiply(BigDecimal.valueOf(0.5)));
            sum = sum.add(sauceService.calculateSaucePrice(pizza.getSauceName(), pizza.getSauceIntensityName()));
            sum = sum.add(toppingService.calculateToppingPrice(pizza.getToppingName1()));
            sum = sum.add(toppingService.calculateToppingPrice(pizza.getToppingName2()));
            sum = sum.add(toppingService.calculateToppingPrice(pizza.getToppingName3()));
            return sum;
        } else {
            Optional<Pizza> pizzaOptional = this.valueWithName(pizza.getName());
            if (pizzaOptional.isPresent()) {
                return pizzaOptional.get().getRetailPrice();
            }
            return BigDecimal.ZERO;
        }
    }


}
