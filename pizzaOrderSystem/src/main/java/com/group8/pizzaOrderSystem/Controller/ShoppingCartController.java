package com.group8.pizzaOrderSystem.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group8.pizzaOrderSystem.foundation.entity.Pizza;
import com.group8.pizzaOrderSystem.foundation.mapper.PizzaMapper;
import com.group8.pizzaOrderSystem.foundation.model.PizzaDTO;
import com.group8.pizzaOrderSystem.foundation.model.ShoppingCart;
import com.group8.pizzaOrderSystem.foundation.service.PizzaService;
import com.group8.pizzaOrderSystem.foundation.service.ShoppingCartService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/cart/addcustompizza")
    public Map<String, Object> addToCart(@CookieValue(name = "cartItems", defaultValue = "") String cartItems,
                                                       @RequestBody PizzaDTO pizza,
                                                       HttpServletResponse response) {
        ShoppingCart shoppingCart = new ShoppingCart();
        if (!cartItems.isEmpty()) {
            String decoded = URLDecoder.decode(cartItems, StandardCharsets.UTF_8);
            shoppingCart = shoppingCartService.deserializeShoppingCart(decoded);
        }

        shoppingCart.addItem(pizza);
        shoppingCart.getItems().forEach(item -> item.setRetailPrice(pizzaService.getPrice(item)));

        try {
            String encoded = URLEncoder.encode(objectMapper.writeValueAsString(shoppingCart), StandardCharsets.UTF_8);
            Cookie cookie = new Cookie("cartItems", encoded);
            LocalDateTime expirationTime = LocalDateTime.now().plusDays(7);
            long expiresInSeconds = expirationTime.toEpochSecond(ZoneOffset.UTC);
            cookie.setMaxAge((int) (expiresInSeconds - System.currentTimeMillis() / 1000));
            cookie.setPath("/");
            response.addCookie(cookie);
            return Map.of("success", true);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Map.of("success", false);
        }
    }

    @PostMapping(value = "/cart/addsignaturepizza")
    public Map<String, Object> addToCart(@CookieValue(value = "cartItems", defaultValue = "") String cartItems,
                                         @RequestBody Map<String, Object> requestBody,
                                         HttpServletResponse response) {
        String pizzaName = MapUtils.getString(requestBody, "signaturePizzaName", "");
        if (pizzaName.isBlank()) {
            return Map.of("success", true);
        }
        ShoppingCart shoppingCart = new ShoppingCart();
        if (!cartItems.isEmpty()) {
            String decoded = URLDecoder.decode(cartItems, StandardCharsets.UTF_8);
            shoppingCart = shoppingCartService.deserializeShoppingCart(decoded);
        }

        Optional<Pizza> pizza = pizzaService.valueWithName(pizzaName);
        shoppingCart.getItems().forEach(item -> item.setRetailPrice(pizzaService.getPrice(item)));
        if (pizza.isPresent()) {
            shoppingCart.addItem(PizzaMapper.toDTO(pizza.get()));
        }

        try {
            String encoded = URLEncoder.encode(objectMapper.writeValueAsString(shoppingCart), StandardCharsets.UTF_8);
            Cookie cookie = new Cookie("cartItems", encoded);
            LocalDateTime expirationTime = LocalDateTime.now().plusDays(7);
            long expiresInSeconds = expirationTime.toEpochSecond(ZoneOffset.UTC);
            cookie.setMaxAge((int) (expiresInSeconds - System.currentTimeMillis() / 1000));
            cookie.setPath("/");
            cookie.setDomain("localhost");
            response.addCookie(cookie);
            return Map.of("success", true);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Map.of("success", false);
        }
    }

    @GetMapping(value = "/cart/remove/{index}")
    public Map<String, Object> removeFromCart(@CookieValue(value = "cartItems", defaultValue = "") String cartItems,
                                 @PathVariable Integer index,
                                 HttpServletResponse response) {
        if (index != null) {
            ShoppingCart shoppingCart = new ShoppingCart();
            if (!cartItems.isEmpty()) {
                shoppingCart = shoppingCartService.deserializeShoppingCart(cartItems);
            }
            shoppingCart.getItems().forEach(item -> item.setRetailPrice(pizzaService.getPrice(item)));
            if (index >= 0 && index < shoppingCart.getItems().size()) {
                shoppingCart.removeItem(index);
            }
            try {
                String encoded = URLEncoder.encode(objectMapper.writeValueAsString(shoppingCart), StandardCharsets.UTF_8);
                Cookie cookie = new Cookie("cartItems", encoded);
                LocalDateTime expirationTime = LocalDateTime.now().plusDays(7);
                long expiresInSeconds = expirationTime.toEpochSecond(ZoneOffset.UTC);
                cookie.setMaxAge((int) (expiresInSeconds - System.currentTimeMillis() / 1000));
                cookie.setPath("/");
                cookie.setDomain("localhost");
                response.addCookie(cookie);
                return Map.of("success", true);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return Map.of("success", false);
            }
        } else {
            return Map.of("success", false);
        }
    }

    @GetMapping(value = "/cart/clear")
    public Map<String, Object> removeAllFromCart(@CookieValue(value = "cartItems", defaultValue = "") String cartItems,
                                    HttpServletResponse response) {
        try {
            String encoded = URLEncoder.encode(objectMapper.writeValueAsString(new ShoppingCart()), StandardCharsets.UTF_8);
            Cookie cookie = new Cookie("cartItems", encoded);
            LocalDateTime expirationTime = LocalDateTime.now().plusDays(7);
            long expiresInSeconds = expirationTime.toEpochSecond(ZoneOffset.UTC);
            cookie.setMaxAge((int) (expiresInSeconds - System.currentTimeMillis() / 1000));
            cookie.setPath("/");
            cookie.setDomain("localhost");
            response.addCookie(cookie);
            return Map.of("success", true);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Map.of("success", false);
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
