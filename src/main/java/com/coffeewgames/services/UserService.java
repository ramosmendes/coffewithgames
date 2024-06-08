package com.coffeewgames.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coffeewgames.dto.UserDto;
import com.coffeewgames.entities.User;
import com.coffeewgames.repositories.UserRepository;
import com.coffeewgames.services.exceptions.DatabaseException;
import com.coffeewgames.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		User obj = repository.findById(id).orElse(null);
		if (obj == null)
			throw new ResourceNotFoundException(id);
		UserDto dto = new UserDto(obj);
		return dto;
	}

	public UserDto insert(User user) {
		User obj = repository.save(user);
		UserDto dto = new UserDto(obj);
		return dto;
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public UserDto update(Long id, User user) {
		try {
			User obj = repository.getReferenceById(id);
			updateData(obj, user);
			repository.save(obj);
			UserDto dto = new UserDto(obj);
			return dto;
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
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
