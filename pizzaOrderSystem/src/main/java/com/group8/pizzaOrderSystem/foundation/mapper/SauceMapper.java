package com.group8.pizzaOrderSystem.foundation.mapper;

import com.group8.pizzaOrderSystem.foundation.entity.Sauce;
import com.group8.pizzaOrderSystem.foundation.model.SauceDTO;

public class SauceMapper {
    public static SauceDTO toDTO(Sauce sauce) {
        return new SauceDTO(sauce.getName());
    }

//    public CheeseLevel toEntity(CheeseLevelDTO cheeseLevelDTO) {
//        // TODO:
//        return null;
//    }
}
