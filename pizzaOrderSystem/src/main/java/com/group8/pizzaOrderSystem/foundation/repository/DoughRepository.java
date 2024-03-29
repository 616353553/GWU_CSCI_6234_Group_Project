package com.group8.pizzaOrderSystem.foundation.repository;

import com.group8.pizzaOrderSystem.foundation.entity.Dough;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoughRepository extends JpaRepository<Dough, Long> {

}
