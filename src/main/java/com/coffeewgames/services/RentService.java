package com.coffeewgames.services;

import java.time.Instant;
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

	public Rent insert(Rent pc) {
		return repository.save(pc);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Rent update(Long id, Rent obj) {
		Rent entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Rent entity, Rent obj) {
		entity.setMoment(Instant.now());
		entity.setTime(obj.getTime());
		entity.setValue(entity.getPc());
	}
}
