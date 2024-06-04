package com.coffeewgames.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeewgames.dto.RentDto;
import com.coffeewgames.entities.Rent;
import com.coffeewgames.repositories.RentRepository;

@Service
public class RentService {

	@Autowired
	RentRepository repository;

	public List<RentDto> findAll() {
		List<Rent> obj = repository.findAll();
		List<RentDto> dto = obj.stream().map(rent -> new RentDto(rent)).collect(Collectors.toList());
		return dto;
	}

	public RentDto findById(Long id) {
		Rent obj = repository.findById(id).get();
		RentDto dto = new RentDto(obj);
		return dto;
	}

	public RentDto insert(Rent rent) {
		Rent obj = repository.save(rent);
		RentDto dto = new RentDto(obj);
		return dto;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public RentDto update(Long id, Rent rent) {
		Rent obj = repository.getReferenceById(id);
		updateData(obj, rent);
		repository.save(obj);
		RentDto dto = new RentDto(obj);
		return dto;

	}

	private void updateData(Rent obj, Rent rent) {
		obj.setMoment(Instant.now());
		obj.setTime(rent.getTime());
		obj.setValue(rent.getPc());
	}
}
