package com.coffeewgames.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeewgames.dto.ComputerDto;
import com.coffeewgames.entities.Computer;
import com.coffeewgames.services.ComputerService;

@RestController
@RequestMapping(value = "/pcs")
public class ComputerController {

	@Autowired
	private ComputerService service;

	@GetMapping
	public ResponseEntity<List<ComputerDto>> findAll() {
		List<ComputerDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ComputerDto> findById(@PathVariable Long id) {
		ComputerDto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<ComputerDto> insert(@RequestBody Computer obj) {
		ComputerDto dto = service.insert(obj);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ComputerDto> update(@PathVariable Long id, @RequestBody Computer obj) {
		ComputerDto dto = service.update(id, obj);
		return ResponseEntity.ok().body(dto);
	}
}
