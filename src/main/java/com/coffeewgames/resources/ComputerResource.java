package com.coffeewgames.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
