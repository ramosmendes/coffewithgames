package com.coffeewgames.dto;

import org.springframework.beans.BeanUtils;

import com.coffeewgames.entities.Food;

public class FoodDto {

	private Long id;
	private String name;
	private Double price;
	private Integer quantity;

	public FoodDto(Food food) {
		BeanUtils.copyProperties(food, this);
	}

	public FoodDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
