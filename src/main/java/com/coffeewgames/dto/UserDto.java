package com.coffeewgames.dto;

import org.springframework.beans.BeanUtils;

import com.coffeewgames.entities.User;

public class UserDto {

	private Long id;
	private String name;
	private String email;

	public UserDto(User user) {
		BeanUtils.copyProperties(user, this);
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

}
