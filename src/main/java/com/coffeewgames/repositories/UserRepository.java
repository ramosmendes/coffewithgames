package com.coffeewgames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeewgames.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
