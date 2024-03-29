package com.group8.pizzaOrderSystem.foundation.repository;

import com.group8.pizzaOrderSystem.foundation.entity.SauceIntensity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SauceIntensityRepository extends JpaRepository<SauceIntensity, Long> {

}