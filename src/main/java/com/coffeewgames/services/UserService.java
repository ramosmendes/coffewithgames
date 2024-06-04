package com.coffeewgames.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeewgames.dto.UserDto;
import com.coffeewgames.entities.User;
import com.coffeewgames.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public List<UserDto> findAll() {
		List<User> obj = repository.findAll();
		List<UserDto> dto = obj.stream().map(user -> new UserDto(user)).collect(Collectors.toList());
		return dto;
	}

	public UserDto findById(Long id) {
		User obj = repository.findById(id).get();
		UserDto dto = new UserDto(obj);
		return dto;
	}

	public UserDto insert(User user) {
		User obj = repository.save(user);
		UserDto dto = new UserDto(obj);
		return dto;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public UserDto update(Long id, User user) {
		User obj = repository.getReferenceById(id);
		updateData(obj, user);
		repository.save(obj);
		UserDto dto = new UserDto(obj);
		return dto;
	}

	private void updateData(User obj, User user) {
		obj.setName(user.getName());
		obj.setPassword(user.getPassword());
		obj.setEmail(user.getEmail());
		obj.setAge(user.getAge());
		obj.setWallet(user.getWallet());
	}

	public boolean isAdult(User user) {
		if (user.getAge() >= 18)
			return true;
		return false;
	}

}
