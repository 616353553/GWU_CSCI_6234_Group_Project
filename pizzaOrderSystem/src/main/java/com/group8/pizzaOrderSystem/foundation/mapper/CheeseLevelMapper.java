package com.group8.pizzaOrderSystem.foundation.mapper;

import com.group8.pizzaOrderSystem.foundation.entity.CheeseLevel;
import com.group8.pizzaOrderSystem.foundation.model.CheeseLevelDTO;

public class CheeseLevelMapper {
    public static CheeseLevelDTO toDTO(CheeseLevel cheeseLevel) {
        return new CheeseLevelDTO(cheeseLevel.getName());
    }

//    public CheeseLevel toEntity(CheeseLevelDTO cheeseLevelDTO) {
//        // TODO:
//        return null;
//    }
}
