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

import com.coffeewgames.entities.Computer;
import com.coffeewgames.services.ComputerService;

@RestController
@RequestMapping(value = "/pcs")
public class ComputerResource {

	@Autowired
	private ComputerService service;

	@GetMapping
	public ResponseEntity<List<Computer>> findAll() {
		List<Computer> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Computer> findById(@PathVariable Long id) {
		Computer obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Computer> insert(@RequestBody Computer obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Computer> update(@PathVariable Long id, @RequestBody Computer obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
