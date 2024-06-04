package com.coffeewgames.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeewgames.dto.FoodDto;
import com.coffeewgames.entities.Food;
import com.coffeewgames.repositories.FoodRepository;

@Service
public class FoodService {

	@Autowired
	FoodRepository repository;

	public List<FoodDto> findAll() {
		List<Food> obj = repository.findAll();
		List<FoodDto> dto = obj.stream().map(food -> new FoodDto(food)).collect(Collectors.toList());
		return dto;
	}

	public FoodDto findById(Long id) {
		Food obj = repository.findById(id).get();
		FoodDto dto = new FoodDto(obj);
		return dto;
	}

	public FoodDto insert(Food food) {
		Food obj = repository.save(food);
		FoodDto dto = new FoodDto(obj);
		return dto;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public FoodDto update(Long id, Food food) {
		Food obj = repository.getReferenceById(id);
		updateData(obj, food);
		repository.save(obj);
		FoodDto dto = new FoodDto(obj);
		return dto;
	}

	private void updateData(Food obj, Food food) {
		obj.setName(food.getName());
		obj.setPrice(food.getPrice());
		obj.setQuantity(food.getQuantity());
	}

}
