package com.group8.pizzaOrderSystem.foundation.mapper;

import com.group8.pizzaOrderSystem.foundation.entity.Dough;
import com.group8.pizzaOrderSystem.foundation.model.DoughDTO;

import java.util.stream.Collectors;

public class DoughMapper {
    public static DoughDTO toDTO(Dough dough) {
        return new DoughDTO(dough.getName(), dough.getSupportedDoughSizes().stream().map(DoughSizeMapper::toDTO).collect(Collectors.toSet()));
    }

//    public CheeseLevel toEntity(CheeseLevelDTO cheeseLevelDTO) {
//        // TODO:
//        return null;
//    }
}
