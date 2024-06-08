package com.coffeewgames.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coffeewgames.dto.RentDto;
import com.coffeewgames.entities.Rent;
import com.coffeewgames.repositories.RentRepository;
import com.coffeewgames.services.exceptions.DatabaseException;
import com.coffeewgames.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		Rent obj = repository.findById(id).orElse(null);
		if (obj == null)
			throw new ResourceNotFoundException(id);
		RentDto dto = new RentDto(obj);
		return dto;
	}

	public RentDto insert(Rent rent) {
		Rent obj = repository.save(rent);
		RentDto dto = new RentDto(obj);
		return dto;
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public RentDto update(Long id, Rent rent) {
		try {
			Rent obj = repository.getReferenceById(id);
			updateData(obj, rent);
			repository.save(obj);
			RentDto dto = new RentDto(obj);
			return dto;
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void updateData(Rent obj, Rent rent) {
		obj.setMoment(Instant.now());
		obj.setTime(rent.getTime());
		obj.calculateValue(rent.getPc());
	}
}
