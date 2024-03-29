package com.group8.pizzaOrderSystem.foundation.mapper;

import com.group8.pizzaOrderSystem.foundation.entity.DoughSize;
import com.group8.pizzaOrderSystem.foundation.model.DoughSizeDTO;

public class DoughSizeMapper {
    public static DoughSizeDTO toDTO(DoughSize doughSize) {
        return new DoughSizeDTO(doughSize.getName(), doughSize.getInch());
    }

//    public CheeseLevel toEntity(CheeseLevelDTO cheeseLevelDTO) {
//        // TODO:
//        return null;
//    }
}
