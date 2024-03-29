package com.group8.pizzaOrderSystem.Controller;

import com.group8.pizzaOrderSystem.foundation.model.PizzaDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingCartController {

    @GetMapping(value = "/cart")
    public String getCart(@CookieValue(value = "cartItems", defaultValue = "") String cartItems) {
        // TODO:
        return "";
    }

    @PostMapping(value = "/cart/add")
    public String addToCart(@CookieValue(value = "cartItems", defaultValue = "") String cartItems, @RequestBody PizzaDTO pizza) {
        // TODO:
        return "";
    }

    @GetMapping(value = "/cart/remove")
    public String removeFromCart(@CookieValue(value = "cartItems", defaultValue = "") String cartItems, int id) {
        // TODO:
        return "";
    }

    @GetMapping(value = "/cart/checkout")
    public String checkout(@CookieValue(value = "cartItems", defaultValue = "") String cartItems) {
        // TODO:
        return "";
    }
}
