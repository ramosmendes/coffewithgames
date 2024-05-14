package com.coffeewgames.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeewgames.entities.Rent;
import com.coffeewgames.repositories.RentRepository;

@Service
public class RentService {

	@Autowired
	RentRepository repository;

	public List<Rent> findAll() {
		return repository.findAll();
	}

	public Rent findById(Long id) {
		Optional<Rent> obj = repository.findById(id);
		return obj.get();
	}
}
