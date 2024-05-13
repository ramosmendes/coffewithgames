package com.coffeewgames.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeewgames.entities.Computer;
import com.coffeewgames.repositories.ComputerRepository;

@Service
public class ComputerService {

	@Autowired
	ComputerRepository repository;

	public List<Computer> findAll() {
		return repository.findAll();
	}

	public Computer findById(Long id) {
		Optional<Computer> obj = repository.findById(id);
		return obj.get();
	}

}
