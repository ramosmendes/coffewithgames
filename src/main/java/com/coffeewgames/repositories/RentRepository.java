package com.coffeewgames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeewgames.entities.Rent;

public interface RentRepository extends JpaRepository<Rent, Long> {

}
