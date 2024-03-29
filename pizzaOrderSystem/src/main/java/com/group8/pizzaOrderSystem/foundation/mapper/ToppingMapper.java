package com.group8.pizzaOrderSystem.foundation.mapper;

import com.group8.pizzaOrderSystem.foundation.entity.Topping;
import com.group8.pizzaOrderSystem.foundation.model.ToppingDTO;

public class ToppingMapper {
    public static ToppingDTO toDTO(Topping topping) {
        return new ToppingDTO(topping.getName(), topping.getVeggie());
    }

//    public CheeseLevel toEntity(CheeseLevelDTO cheeseLevelDTO) {
//        // TODO:
//        return null;
//    }
}
