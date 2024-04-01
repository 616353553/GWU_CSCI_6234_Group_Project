package com.group8.pizzaOrderSystem.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group8.pizzaOrderSystem.foundation.model.PizzaDTO;
import com.group8.pizzaOrderSystem.foundation.model.ShoppingCart;
import com.group8.pizzaOrderSystem.foundation.service.PizzaService;
import com.group8.pizzaOrderSystem.foundation.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ShoppingCartController {
    private static final String DOMAIN = "localhost:8080";

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "/cart")
    public Map<String, Object> getCart(@CookieValue(value = "cartItems", defaultValue = "", required = false) String cartItems) {
        Map<String, Object> map = new HashMap<>();
        ShoppingCart shoppingCart = null;
        if (cartItems != null && !cartItems.isEmpty()) {
            shoppingCart = shoppingCartService.deserializeShoppingCart(cartItems);
        }
        if (shoppingCart != null) {
            map.put("cartCount", shoppingCart.getItems().size());
            map.put("total", "$" + shoppingCart.getTotal());
            try {
                map.put("items", objectMapper.writeValueAsString(shoppingCart.getItems()));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {
            map.put("cartCount", 0);
            map.put("total", "$0");
        }
        return map;
    }

    @PostMapping(value = "/cart/add")
    public String addToCart(@CookieValue(value = "cartItems", defaultValue = "", required = false) String cartItems, @RequestBody PizzaDTO pizza) {
        ShoppingCart shoppingCart = new ShoppingCart();
        if (cartItems != null && !cartItems.isEmpty()) {
            shoppingCart = shoppingCartService.deserializeShoppingCart(cartItems);
        }
        pizza.setRetailPrice(pizzaService.getPrice(pizza));
        shoppingCart.addItem(pizza);
        try {
            return objectMapper.writeValueAsString(shoppingCart);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @GetMapping(value = "/cart/remove")
    public String removeFromCart(@CookieValue(value = "cartItems", defaultValue = "", required = false) String cartItems, int index) {
        ShoppingCart shoppingCart = new ShoppingCart();
        if (cartItems != null && !cartItems.isEmpty()) {
            shoppingCart = shoppingCartService.deserializeShoppingCart(cartItems);
        }
        if (index < shoppingCart.getItems().size()) {
            shoppingCart.removeItem(index);
        }
        try {
            return objectMapper.writeValueAsString(shoppingCart);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @GetMapping(value = "/cart/checkout")
    public Map<String, Object> checkout(@CookieValue(value = "cartItems", defaultValue = "", required = false) String cartItems) {
        ShoppingCart shoppingCart = new ShoppingCart();
        if (cartItems != null && !cartItems.isEmpty()) {
            shoppingCart = shoppingCartService.deserializeShoppingCart(cartItems);
        }
        if (shoppingCart.getItems().size() > 0) {
            return Map.of("success", true, "errMsg", "");
        } else {
            return Map.of("success", false, "errMsg", "Empty cart");
        }
    }
}
