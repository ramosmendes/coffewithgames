package com.coffeewgames.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeewgames.dto.ComputerDto;
import com.coffeewgames.entities.Computer;
import com.coffeewgames.repositories.ComputerRepository;

@Service
public class ComputerService {

	@Autowired
	ComputerRepository repository;

	public List<ComputerDto> findAll() {
		List<Computer> obj = repository.findAll();
		List<ComputerDto> dto = obj.stream().map(pc -> new ComputerDto(pc)).collect(Collectors.toList());
		return dto;
	}

	public ComputerDto findById(Long id) {
		Computer obj = repository.findById(id).get();
		ComputerDto dto = new ComputerDto(obj);
		return dto;
	}

	public ComputerDto insert(Computer pc) {
		Computer obj = repository.save(pc);
		ComputerDto dto = new ComputerDto(obj);
		return dto;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public ComputerDto update(Long id, Computer pc) {
		Computer obj = repository.getReferenceById(id);
		updateData(obj, pc);
		repository.save(obj);
		ComputerDto dto = new ComputerDto(obj);
		return dto;
	}

	private void updateData(Computer obj, Computer pc) {
		obj.setName(pc.getName());
		obj.setTypePc(pc.getTypePc());

	}
}
