package com.coffeewgames.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.coffeewgames.entities.Rent;
import com.coffeewgames.entities.User;

public class UserDto {

	private Long id;
	private String name;
	private String email;
	private List<Rent> rents = new ArrayList<>();

	public UserDto(User user) {
		BeanUtils.copyProperties(user, this);
		this.rents.addAll(user.getRent());
	}

	public UserDto() {

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Rent> getRents() {
		return rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

}
