package com.coffeewgames.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.coffeewgames.entities.User;
import com.coffeewgames.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public void run(String... args) throws Exception {

		User u1 = new User("Rivaldo", 18, "jeffjeff@gmail.com", "1548s9z2pw", 150.55);
		User u2 = new User("Jeff", 18, "jeffjeff@gmail.com", "1548s9z2pw", 150.55);

		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
