package com.coffeewgames.dto;

import java.time.Instant;

import org.springframework.beans.BeanUtils;

import com.coffeewgames.entities.Rent;
import com.coffeewgames.entities.enums.RentStatus;

public class RentDTO {

	private Long id;
	private Instant moment;
	private Double value;
	private RentStatus rentStatus;

	public RentDTO(Rent rent) {
		BeanUtils.copyProperties(rent, this);
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

}
