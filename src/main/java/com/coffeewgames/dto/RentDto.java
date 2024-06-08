package com.coffeewgames.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.coffeewgames.entities.Computer;
import com.coffeewgames.entities.Food;
import com.coffeewgames.entities.Payment;
import com.coffeewgames.entities.Rent;
import com.coffeewgames.entities.enums.RentStatus;

public class RentDto {

	private Long id;
	private Instant moment;
	private Double value;
	private RentStatus rentStatus;
	private Computer pc;
	private Payment payment;
	private List<Food> foods = new ArrayList<>();

	public RentDto(Rent rent) {
		BeanUtils.copyProperties(rent, this);
		this.foods.addAll(rent.getFood());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public RentStatus getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(RentStatus rentStatus) {
		this.rentStatus = rentStatus;
	}

	public Computer getPc() {
		return pc;
	}

	public void setPc(Computer pc) {
		this.pc = pc;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

}
