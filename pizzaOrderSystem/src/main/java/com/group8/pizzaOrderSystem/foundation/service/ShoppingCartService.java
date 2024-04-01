package com.group8.pizzaOrderSystem.foundation.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group8.pizzaOrderSystem.foundation.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    @Autowired
    private ObjectMapper objectMapper;

    public String serializeShoppingCart(ShoppingCart shoppingCart) {
        try {
            return objectMapper.writeValueAsString(shoppingCart);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ShoppingCart deserializeShoppingCart(String json) {
        try {
            return objectMapper.readValue(json, ShoppingCart.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
