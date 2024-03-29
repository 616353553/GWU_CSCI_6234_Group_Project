package com.group8.pizzaOrderSystem.foundation.repository;

import com.group8.pizzaOrderSystem.foundation.entity.Cheese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheeseRepository extends JpaRepository<Cheese, Long> {

}