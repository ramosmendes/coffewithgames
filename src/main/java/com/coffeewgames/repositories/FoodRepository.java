package com.coffeewgames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeewgames.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
