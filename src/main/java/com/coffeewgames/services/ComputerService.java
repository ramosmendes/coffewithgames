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

	public Computer insert(Computer pc) {
		return repository.save(pc);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Computer update(Long id, Computer obj) {
		Computer entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Computer entity, Computer obj) {
		entity.setName(obj.getName());
		entity.setTypePc(obj.getTypePc());

	}
}
