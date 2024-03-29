package com.group8.pizzaOrderSystem.foundation.mapper;

import com.group8.pizzaOrderSystem.foundation.entity.SauceIntensity;
import com.group8.pizzaOrderSystem.foundation.model.SauceIntensityDTO;

public class SauceIntensityMapper {
    public static SauceIntensityDTO toDTO(SauceIntensity sauceIntensity) {
        return new SauceIntensityDTO(sauceIntensity.getName());
    }

//    public CheeseLevel toEntity(CheeseLevelDTO cheeseLevelDTO) {
//        // TODO:
//        return null;
//    }
}
