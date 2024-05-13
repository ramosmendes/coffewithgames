package com.coffeewgames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeewgames.entities.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Long> {

}
