package com.group8.pizzaOrderSystem.foundation.mapper;

import com.group8.pizzaOrderSystem.foundation.entity.Cheese;
import com.group8.pizzaOrderSystem.foundation.model.CheeseDTO;

public class CheeseMapper {
    public static CheeseDTO toDTO(Cheese cheese) {
        return new CheeseDTO(cheese.getName());
    }

//    public Cheese toEntity(CheeseDTO cheeseDTO) {
//        // TODO:
//        return null;
//    }
}

